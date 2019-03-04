package com.syz.androidroomtest.data.repository

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 *   @ClassName: BaseRepository
 *   @Date: 2019/3/4 4:49 PM
 *   @Author: syz
 *   @Description:
 */
open class BaseRepository {

    //collection and manager rxJava Disposes
    private var compositeDisposable: CompositeDisposable? = null


    protected fun addDisposable(disposable: Disposable) {
        if (compositeDisposable == null)
            compositeDisposable = CompositeDisposable()
        compositeDisposable?.add(disposable)
    }


    fun clear(){
        compositeDisposable?.clear()
        this.compositeDisposable = null
    }
}