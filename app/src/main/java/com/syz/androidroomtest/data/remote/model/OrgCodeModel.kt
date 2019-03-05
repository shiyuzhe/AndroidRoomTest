package com.syz.androidroomtest.data.remote.model

import com.syz.androidroomtest.data.room.bean.OrgCode

/**
 *   @ClassName: OrgCodeModel
 *   @Date: 2019/3/5 10:34 AM
 *   @Author: syz
 *   @Description:
 */
data class OrgCodeModel(
    val datas: MutableList<OrgCode>,
    val msg: String,
    val status: String
)