package com.syz.androidroomtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var disposable:Disposable?=null
    private var users = mutableListOf<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        add.setOnClickListener {
            Observable.range(1,3).observeOn(Schedulers.io()).map {
                User("f:$it","l:$it")
            }.subscribeBy {
                    AppDatabase.instance.userDao().insertAll(it)
                }
        }
        delete.setOnClickListener {
            Observable.just(users).observeOn(Schedulers.io()).filter { it.isNotEmpty() }
                .subscribeBy {
                    AppDatabase.instance.userDao().delete(it[0])
                }
        }
         disposable = AppDatabase.instance.userDao().getAllUser().map {
             users = it as MutableList<User>
            it.size
        }.observeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread()).subscribeBy {
            //数据改变会直接回调到这里
             getUser.text = "data size : $it"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }
}
