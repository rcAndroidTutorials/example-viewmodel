package com.youtube.example.exampleviewmodel.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.youtube.example.exampleviewmodel.R
import com.youtube.example.exampleviewmodel.models.User
import com.youtube.example.exampleviewmodel.models.UsersRepository

internal class HomeViewModel(val userID: String, private val repository: UsersRepository) : ViewModel() {
    private val viewMLD = MutableLiveData<ViewState>()
    val viewLD: LiveData<ViewState> = viewMLD
    init {
        loadUser()
    }
    private fun loadUser() {
        val user: User = repository.fetchUserFromBackend(userID)
        viewMLD.value = ViewState(user.name, user.age.toString(), R.drawable.usuario)
    }
    fun happyBirthday(){
        val user = repository.happyBirthday()
        viewMLD.value = ViewState(user.name, user.age.toString(), R.drawable.usuario)
    }
}