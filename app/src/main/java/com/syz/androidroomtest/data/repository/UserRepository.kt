package com.syz.androidroomtest.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.syz.androidroomtest.data.room.AppDatabase
import com.syz.androidroomtest.data.room.bean.User
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 *   @ClassName: UserRepository
 *   @Date: 2019/3/4 10:06 AM
 *   @Author: syz
 *   @Description:
 */
class UserRepository:BaseRepository() {

    //被观察者，数据改变时会通知观察者（activity/fragment）
     val users: MutableLiveData<List<User>> by lazy {
        MutableLiveData<List<User>>().also {
            loadUsers()
        }
    }
    /**
     * 网络的操作同步到数据库后
     * 数据库的更新会驱动ui实时更新
     */
    private val userRemote by lazy {
        AppDatabase.instance.userDao()
    }
    private val userRoom by lazy {
        AppDatabase.instance.userDao()
    }


    private fun loadUsers() {
        // Do an asynchronous operation to fetch users.
        userRemote.getAllUser2().map {
            if (it.isNullOrEmpty()) {
                return@map userRoom.getAll()
            }
            Log.e("syz", "updateCache")
            it
        }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeBy {
            users.value = it
        }.let {
            addDisposable(it)
        }
    }

    /**
     * 删除给定User
     */
    fun deleteUser(user: User) = Observable.just(user).observeOn(Schedulers.io()).subscribeBy {
            AppDatabase.instance.userDao().delete(it)
        }.let {
        addDisposable(it)
    }


    /**
     * 每秒新增一个
     */
    fun addUserInterval() = Observable.interval(1, TimeUnit.SECONDS).observeOn(Schedulers.io()).map {
        User("f:$it", "l:$it")
        }.subscribeBy {
            AppDatabase.instance.userDao().insertAll(it)
        }.let { addDisposable(it) }


}