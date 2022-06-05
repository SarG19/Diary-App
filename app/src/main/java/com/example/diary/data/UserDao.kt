package com.example.diary.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.diary.model.User

@Dao
interface DataDao {

    @Insert
    suspend fun addUser(user: User)

    @Query("SELECT * FROM data_table ORDER BY Date ASC")
    fun readAllData(): LiveData<List<User>>
}