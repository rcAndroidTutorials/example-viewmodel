package com.youtube.example.exampleviewmodel.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.youtube.example.exampleviewmodel.common.SingleLiveEvent

class LoginViewModel : ViewModel() {
    private val _loginResultSLE = SingleLiveEvent<Boolean>()
    val loginResultLD: LiveData<Boolean> = _loginResultSLE

    fun login(username: String, password: String) {
        if (username=="Larry" && password=="0000") {
            _loginResultSLE.value = true
        } else {
            _loginResultSLE.value = false
        }
    }

}