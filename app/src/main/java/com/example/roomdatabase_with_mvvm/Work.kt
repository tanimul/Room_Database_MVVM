package com.example.roomdatabase_with_mvvm

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "work_table")
data class Work(
    val workName: String,
    val details: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int=0
}
