package com.syz.androidroomtest.data.remote

import com.syz.androidroomtest.data.remote.model.*
import io.reactivex.Observable
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiStores {

    /**
     * 车辆信息
     */
    @POST("CarMsg")
    fun getCarMsg(@Query("app") params:String): Observable<CarMsgModel>



    /**
     * orgsTree
     */
    @POST("orgsTree")
    fun getOrgsTree(@Query("app") param: String = "{userID:273}"): Observable<OrgCodeModel>


}