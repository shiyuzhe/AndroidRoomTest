package com.syz.androidroomtest.vm

import android.content.ClipData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 *   @ClassName: ShareViewModel
 *   @Date: 2019/3/1 1:56 PM
 *   @Author: syz
 *   @Description:共享ViewModel来处理Fragment直接的通信,Main2Activity
 */
class ShareViewModel: ViewModel() {

    val items : MutableLiveData<ClipData.Item> =  MutableLiveData()
}