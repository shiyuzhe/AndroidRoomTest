package com.syz.androidroomtest.data.remote.model

import com.syz.androidroomtest.data.room.bean.CarMsg

/**
 *   by  :   syz
 *   Time: 2019/1/11 14:05
 *   Description:
 */

data class CarMsgModel(
    val `data`: List<CarMsg>,
    val msg: String,
    val status: String) {

    data class requestBean(
            val busiNum: String="",
            val plate:String=""
    )
}

