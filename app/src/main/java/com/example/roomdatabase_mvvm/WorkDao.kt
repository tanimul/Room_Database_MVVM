package com.example.roomdatabase_mvvm

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface WorkDao {


    @Insert
    suspend fun insert(work: Work) //insert single data


    @Update
    suspend fun update(work: Work) //update single data


    @Delete
    suspend fun delete(work: Work) //delete single data


    @Query("DELETE FROM work_table")
    suspend fun DeleteAllWorks() //delete all work


    @Query("SELECT * FROM work_table ORDER BY id ASC")
    fun getAllWorks(): LiveData<List<Work>> //showing data


}