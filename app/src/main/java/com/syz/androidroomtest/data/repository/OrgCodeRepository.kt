package com.syz.androidroomtest.data.repository

import androidx.lifecycle.MutableLiveData
import com.syz.androidroomtest.data.remote.Api
import com.syz.androidroomtest.data.room.AppDatabase
import com.syz.androidroomtest.data.room.bean.OrgCode
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

/**
 *   @ClassName: OrgCodeRepository
 *   @Date: 2019/3/5 11:14 AM
 *   @Author: syz
 *   @Description:
 */
class OrgCodeRepository:BaseRepository(){


    //被观察者，数据改变时会通知观察者（activity/fragment）
    val codes: MutableLiveData<List<OrgCode>> by lazy {
        MutableLiveData<List<OrgCode>>().also {
            loadCodes()
        }
    }

    private val codeRoom by lazy {
        AppDatabase.instance.orgCodeDao()
    }
    private val codeRemote by lazy {
        Api.api
    }

    private fun loadCodes(){
        codeRoom.getOrgCodes().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeBy {
            codes.value = it
        }.let {
            addDisposable(it)
        }

    }
    fun getOrgCodes(){
        codeRemote.getOrgsTree().subscribeOn(Schedulers.io()).subscribeBy {
            if(it.datas.isNotEmpty()){
                for (i in it.datas)
                    codeRoom.insertAll(i)
            }
        }.let {
            addDisposable(it)
        }
    }

}