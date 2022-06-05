package com.example.diary.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "data_table")
data class User(
    @PrimaryKey(autoGenerate = false)
    val Date: String,
    val Title: String,
    val Note: String): Parcelable