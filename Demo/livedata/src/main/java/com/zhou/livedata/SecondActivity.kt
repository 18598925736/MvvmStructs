package com.zhou.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.ViewModelStore
import kotlinx.android.synthetic.main.activity_main.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userModel = ViewModelProvider(this).get(UserModel::class.java)
        userModel.userLiveData.observe(this, Observer<User> {
            Log.d("hanTag", "MainActivity2:侦测到User发生变化$it")
            textView.text = it.toString()
        })

        textView.setOnClickListener {
            Log.d("hanTag", "MainActivity2:主动触发User的变化，可能是触发网络请求")
            userModel.loadUser()
        }


    }
}
