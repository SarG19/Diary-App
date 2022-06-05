package com.example.diary.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.diary.data.Datasource
import com.example.diary.model.User
import com.example.diary.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<User>>
    private val repository: UserRepository

    init{
        val dataDao = Datasource.getDatabase(application).dataDao()
        repository = UserRepository(dataDao)
        readAllData = repository.readAllData
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(user)
        }
    }

}