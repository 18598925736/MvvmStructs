package com.zhou.livedata

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserModel : ViewModel() {
    val userLiveData = MutableLiveData<User>() // LiveData除了可以发送数据之外，还可以缓存数据(参见setValue getValue)

    private var seri = 0

    init {
        Log.d("hanTag", "UserModel:初始化,这里可以触发用加载数据操作")
        userLiveData.postValue(User("hank$seri", "male"))
    }

    fun loadUser() {
        userLiveData.postValue(User("hank${++seri}", "male"))//post一次之后便会缓存起来
        Log.d(
            "hanTag",
            "UserModel:做必要的操作来更新userLiveData,比如网络请求，更新User缓存${userLiveData.value?.name}"
        )
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("hanTag", "听说ViewModel会感知owner的生命周期，在onwer销毁之前先销毁自己")
    }

}