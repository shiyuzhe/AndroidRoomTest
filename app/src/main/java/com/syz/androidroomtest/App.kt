package com.syz.androidroomtest

import android.app.Application

class App:Application() {
    companion object {
        private var instance:Application?=null
        fun getIns() = instance!!
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}