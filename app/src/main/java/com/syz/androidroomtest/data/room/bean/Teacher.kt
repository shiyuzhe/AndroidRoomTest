package com.syz.androidroomtest.data.room.bean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *   @ClassName: Teacher
 *   @Date: 2019/3/5 1:50 PM
 *   @Author: syz
 *   @Description:
 */
@Entity
data class Teacher (
    @ColumnInfo var age: String,
    @ColumnInfo var name: String,
    @PrimaryKey var id:String,
    @ColumnInfo var num:Int?
)