package com.syz.androidroomtest.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.syz.androidroomtest.data.repository.OrgCodeRepository
import com.syz.androidroomtest.data.room.bean.OrgCode

/**
 *   @ClassName: OrgCodeViewModel
 *   @Date: 2019/3/5 11:26 AM
 *   @Author: syz
 *   @Description:
 */
class OrgCodeViewModel:ViewModel() {

    override fun onCleared() {
        super.onCleared()
        codeRepository.clear()
    }
    private val codeRepository by lazy {
        OrgCodeRepository()
    }

    fun getCodes():LiveData<List<OrgCode>> = codeRepository.codes

    fun addCodes(){
        codeRepository.getOrgCodes()
    }
}