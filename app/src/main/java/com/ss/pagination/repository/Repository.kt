package com.ss.pagination.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.ss.pagination.model.Result
import com.ss.pagination.util.Constants.DEFAULT_PAGE_SIZE
import com.ss.pagination.util.Constants.apiService

class Repository {

    fun getMoviesLiveData(pagingConfig: PagingConfig = getDefaultPageConfig()): LiveData<PagingData<Result>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = { PagingSource(apiService) }
        ).liveData
    }

    private fun getDefaultPageConfig(): PagingConfig {
        return PagingConfig(pageSize = DEFAULT_PAGE_SIZE, enablePlaceholders = true)
    }
}