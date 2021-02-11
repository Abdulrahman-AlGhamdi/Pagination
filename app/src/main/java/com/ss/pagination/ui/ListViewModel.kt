package com.ss.pagination.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.ss.pagination.model.Result
import com.ss.pagination.repository.Repository

class ListViewModel: ViewModel() {

    private val repository = Repository()

    fun getMovies(): LiveData<PagingData<Result>> {
        return repository.getMoviesLiveData()
    }
}