package com.syz.androidroomtest.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


abstract class BaseActivity(private val layoutId:Int):AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        init()
    }

    abstract fun init()
}