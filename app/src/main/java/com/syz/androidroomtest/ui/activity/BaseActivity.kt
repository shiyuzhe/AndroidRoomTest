package com.syz.androidroomtest.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent



abstract class BaseActivity(private val layoutId:Int):AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
//        lifecycle.addObserver(this)
        init()
    }

    abstract fun init()


//    private  val tag = "syz"
//
//    // 使用注解  @OnLifecycleEvent 来表明该方法需要监听指定的生命周期事件
//    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
//    fun connectListener() {
//        Log.e(tag, "connectListener:  --------   onResume" )
//
//
//    }
//
//    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
//    fun disconnectListener() {
//        Log.e(tag, "disconnectListener: -------   onPause")
//    }

}