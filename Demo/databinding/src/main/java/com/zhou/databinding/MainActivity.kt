package com.zhou.databinding

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayMap
import com.zhou.databinding.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.title = "asfdsaf"

        val map = ObservableArrayMap<String, Any>().apply { put("count", 0) }
        binding.map = map

        binding.userModel = UserModel()

        Thread {
            for (i in 0..100) {
                binding.title = "asfdsaf$i" // 数据变更时，UI会发生变更
                map["count"] = "count$i"

                Thread.sleep(10)
            }
        }.start()


        btnChangeTitle.setOnClickListener {
            tvTitle.text = "改变之后的值title"
        }

        btnToastTitle.setOnClickListener {
            Log.d("xxxxxxaaaaaaa", "${binding.title}")
        }
    }
}
