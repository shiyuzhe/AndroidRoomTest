package com.syz.androidroomtest.data.room.bean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *   @ClassName: OrgCode
 *   @Date: 2019/3/5 10:35 AM
 *   @Author: syz
 *   @Description:
 */
@Entity
data class OrgCode(@ColumnInfo var code: String,
                   @ColumnInfo   var fatherId: String,
                   @PrimaryKey    var id: String,
                   @ColumnInfo    var name: String)