package com.syz.androidroomtest.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.syz.androidroomtest.data.repository.UserRepository
import com.syz.androidroomtest.data.room.bean.User


class UserViewModel:ViewModel() {

    override fun onCleared() {
        super.onCleared()
        userRepository.clear()
    }

    private val userRepository:UserRepository by lazy {
        UserRepository()
    }

    fun getUsers(): LiveData<List<User>> {
        return userRepository.users
    }



    fun addUserInterval(){
        userRepository.addUserInterval()
    }

    fun deleteUser(){

        getUsers().value?.get(0)?.let {
            userRepository.deleteUser(it)
        }
    }

    fun deleteUserById(id:Int){
        getUsers().value?.find(id)?.let {
            userRepository.deleteUser(it)
        }
    }

}
fun List<User>.find(id:Int): User?{
    for (i in this){
        if(i.uid == id)
            return i
    }
    return null
}
