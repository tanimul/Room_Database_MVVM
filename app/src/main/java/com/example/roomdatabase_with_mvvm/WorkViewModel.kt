package com.example.roomdatabase_with_mvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WorkViewModel(application: Application) : AndroidViewModel(application) {
    val allWorkes: LiveData<List<Work>>
    val repository: WorkRepository

    init {
        val workDao = WorkDatabase.getDatabase(application).workDao()
        repository = WorkRepository(workDao)
        allWorkes = repository.allworkes
    }

    fun insertWork(work: Work) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(work)
    }

    fun updateWork(work: Work) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(work)
    }

    fun deleteWork(work: Work) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(work)
    }

    fun deleteAllWorks() = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteAllWorks()
    }


}
