package com.example.roomdatabase_mvvm

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "work_table")
data class Work(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val workname: String,
    val details: String
)
