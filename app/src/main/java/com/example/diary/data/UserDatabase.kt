package com.example.diary.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.diary.model.Notes
import com.example.diary.model.User

@Database(entities = [User::class], version =1, exportSchema = false)
abstract class Datasource: RoomDatabase() {

    abstract fun dataDao(): DataDao

    companion object{
        @Volatile
        private var INSTANCE: Datasource? = null

        fun getDatabase(context: Context): Datasource{
            val tempInstance = INSTANCE
            if(tempInstance!= null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Datasource::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
    fun loadNotes(): List<Notes>{
        return listOf<Notes>(

        )
    }
}