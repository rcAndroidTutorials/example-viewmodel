package com.youtube.example.exampleviewmodel.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.youtube.example.exampleviewmodel.models.UsersRepository

class HomeVMFactory(private val userID: String): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(userID, UsersRepository()) as T
    }
}
