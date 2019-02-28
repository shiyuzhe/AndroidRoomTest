package com.syz.androidroomtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        add.setOnClickListener {
            Thread{
                AppDatabase.instance.userDao().insertAll(User("f","l"),User("ff","ll"))
            }.start()
        }
        delete.setOnClickListener {
            Thread{
                val users = AppDatabase.instance.userDao().getAll()
                if(users.isNotEmpty())
                    AppDatabase.instance.userDao().delete(users[0])
            }.start()
        }
        getUser.setOnClickListener {
            Thread{
                var str = ""
                for (user1 in AppDatabase.instance.userDao().getAll()) {
                    str += user1.toString()+"\n"
                }
                runOnUiThread { getUser.text = str }
            }.start()
        }
//
    }
}
