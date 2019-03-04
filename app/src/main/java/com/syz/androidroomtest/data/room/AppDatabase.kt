package com.syz.androidroomtest.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room
import com.syz.androidroomtest.App

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        val instance : AppDatabase by lazy {
             val build = Room.databaseBuilder(
                 App.getIns().applicationContext,
                 AppDatabase::class.java, "word_database"
             ).build()
            build
        }
    }

    abstract fun userDao(): UserDao
}