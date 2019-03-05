package com.syz.androidroomtest.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room
import com.syz.androidroomtest.App
import com.syz.androidroomtest.data.room.bean.OrgCode
import com.syz.androidroomtest.data.room.bean.User
import com.syz.androidroomtest.data.room.dao.OrgCodeDao
import com.syz.androidroomtest.data.room.dao.UserDao
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.room.migration.Migration
import com.syz.androidroomtest.data.room.bean.Teacher


@Database(entities = [User::class,OrgCode::class,Teacher::class], version = 4)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        /**
         * 升级数据库，新增表Teacher
         */
        private val MIGRATION_2_3: Migration = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                //此处对于数据库中的所有更新都需要写下面的代码
                database.execSQL("CREATE TABLE IF NOT EXISTS `Teacher` (`age` TEXT NOT NULL, `name` TEXT NOT NULL, `id` TEXT NOT NULL, PRIMARY KEY(`id`))")
            }
        }

        private val MIGRATION_3_4: Migration = object : Migration(3,4) {
            override fun migrate(database: SupportSQLiteDatabase) {
                //给Teacher表新增一个字段num:Int
                //add column 不能用NOT NULL，num在Teacher中要设为可空
                database.execSQL("ALTER TABLE `Teacher` ADD COLUMN `num` INTEGER")
            }
        }
        val instance : AppDatabase by lazy {
             val build = Room.databaseBuilder(
                 App.getIns().applicationContext,
                 AppDatabase::class.java, "word_database"
             ).addMigrations(MIGRATION_2_3, MIGRATION_3_4)
//                 .fallbackToDestructiveMigration()//删除已有表，并重新创建
                 .build()
            build
        }
    }

    abstract fun userDao(): UserDao

    abstract fun orgCodeDao():OrgCodeDao
}