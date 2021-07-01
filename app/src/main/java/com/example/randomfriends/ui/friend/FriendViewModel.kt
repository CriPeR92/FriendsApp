package com.example.randomfriends.ui.friend

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.randomfriends.base.BaseViewModel


class FriendViewModel(application: Application) : BaseViewModel(application) {

    val name = MutableLiveData<String?>()
    val image = MutableLiveData<String?>()
    val address = MutableLiveData<String?>()
    val city = MutableLiveData<String?>()
    val state = MutableLiveData<String?>()
    val country = MutableLiveData<String?>()
    val email = MutableLiveData<String?>()
    val cellphone = MutableLiveData<String?>()
    val sendEmail = MutableLiveData<Boolean>()

    fun sendEmail(email: String) {
        sendEmail.postValue(true)
    }

}