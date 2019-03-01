package com.syz.androidroomtest.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.syz.androidroomtest.room.AppDatabase
import com.syz.androidroomtest.room.User
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import java.util.concurrent.TimeUnit


class UserViewModel: BaseViewModel() {



    private val users: MutableLiveData<List<User>> by lazy {
        MutableLiveData<List<User>>().also {
            loadUsers()
        }
    }

    fun getUsers(): LiveData<List<User>> {
        return users
    }

    fun addUser(){
        addDisposable(Observable.range(1, 3).observeOn(Schedulers.io()).map {
            User("f:$it", "l:$it")
        }.subscribeBy {
            AppDatabase.instance.userDao().insertAll(it)
        })
    }

    fun addUserInterval(){
        addDisposable(Observable.interval(1,TimeUnit.SECONDS).observeOn(Schedulers.io()).map {
            User("f:$it", "l:$it")
        }.subscribeBy {
            AppDatabase.instance.userDao().insertAll(it)
        })
    }

    fun deleteUser(){
        if(users.value.isNullOrEmpty()){
            return
        }
        addDisposable( Observable.just<User>(users.value?.get(0)).observeOn(Schedulers.io())
            .subscribeBy {
                AppDatabase.instance.userDao().delete(it)
            })

    }

    private fun loadUsers() {
        // Do an asynchronous operation to fetch users.
        addDisposable(
            AppDatabase.instance.userDao().getAllUser2().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribeBy {
                //set on UI Thread
                users.setValue(it)
                //set on background Thread
//                users.postValue(it)
            })
        //网络请求
        //请求成功时更新数据
    }

}