package com.syz.androidroomtest.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 *  ui相关数据处理
 *  activity调用onDestroy之前持有数据，界面状态的改变不会影响数据
 *  可感知界面状态，只有界面可见才会发送数据给界面
 *  界面在onChanged中更新ui，在后台时不会接收到数据。
 *
 */
open class BaseViewModel:ViewModel() {


    override fun onCleared() {
        super.onCleared()
        Log.e("syz","call onCleared")
        disposeAll()
        this.compositeDisposable = null
    }


    private var compositeDisposable: CompositeDisposable? = null

    private fun disposeAll() {
        when (compositeDisposable == null) {
            true -> return
            false -> if (compositeDisposable!!.isDisposed) compositeDisposable?.clear()
        }
        if (compositeDisposable == null)
            return
        else (compositeDisposable?.isDisposed)
        compositeDisposable?.clear()
    }

    fun addDisposable(disposable: Disposable) {
        if (compositeDisposable == null)
            compositeDisposable = CompositeDisposable()
        compositeDisposable?.add(disposable)
    }
}