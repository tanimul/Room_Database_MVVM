package com.example.roomdatabase_with_mvvm

import android.app.Application
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData


class WorkRepository(private val workDao: WorkDao) {

    var allworkes: LiveData<List<Work>> = workDao.getAllWorks()


    suspend fun insert(work: Work) {
        workDao.insert(work)
    }

    suspend fun delete(work: Work) {
        workDao.delete(work)
    }

    suspend fun update(work: Work) {
        workDao.update(work)
    }

    suspend fun deleteAllWorks() {
        workDao.deleteAllWorks()
    }


}