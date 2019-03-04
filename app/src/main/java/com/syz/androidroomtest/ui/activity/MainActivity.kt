package com.syz.androidroomtest.ui.activity

import android.content.Intent
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.syz.androidroomtest.R
import com.syz.androidroomtest.vm.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(R.layout.activity_main) {

    override fun init() {


        val model = ViewModelProviders.of(this).get(UserViewModel::class.java)
//        model.getUsers().observeForever {
//        getUser.text = "data size : $it"
//        }

//        model.getNetStatus().observeForever {
//            when(it){
//                BaseViewModel.NetStatus.SUCCESS -> {Log.e("syz","BaseViewModel.NetStatus.SUCCESS")}
//                BaseViewModel.NetStatus.ERROR ->  {Log.e("syz","BaseViewModel.NetStatus.ERROR")}
//                BaseViewModel.NetStatus.NO_NETWORK ->  {Log.e("syz","BaseViewModel.NetStatus.NO_NETWORK")}
//                null -> {
//                }
//            }
//        }
        model.getUsers().observeForever {  }

        model.getUsers().observe(this,androidx.lifecycle.Observer {
            //
            Log.e("syz","update UI--${it.size}")
            getUser.text = "data size : ${it.size}"
        })

        add.setOnClickListener {
            model.addUserInterval()
        }
        delete.setOnClickListener {
            model.deleteUser()
        }
        getUser.setOnClickListener { startActivity(Intent(this, Main2Activity::class.java)) }
    }

}
