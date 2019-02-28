package com.syz.androidroomtest

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Room

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