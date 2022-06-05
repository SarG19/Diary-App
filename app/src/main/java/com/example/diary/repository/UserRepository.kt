package com.example.diary.repository

import androidx.lifecycle.LiveData
import com.example.diary.data.DataDao
import com.example.diary.model.User

class UserRepository(private val dataDao: DataDao) {
    val readAllData: LiveData<List<User>> = dataDao.readAllData()

    suspend fun addUser(user: User){
        dataDao.addUser(user)
    }
}