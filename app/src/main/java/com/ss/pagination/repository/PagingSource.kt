package com.ss.pagination.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ss.pagination.api.ApiService
import com.ss.pagination.model.Result
import com.ss.pagination.util.Constants.DEFAULT_PAGE_INDEX
import retrofit2.HttpException
import java.io.IOException

class PagingSource(private val apiService: ApiService) : PagingSource<Int, Result>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {

        val page = params.key ?: DEFAULT_PAGE_INDEX

        return try {
            val response = apiService.getPopularMovie(page)
            val result = response.body()?.results
            LoadResult.Page(
                result!!, prevKey = if (page == DEFAULT_PAGE_INDEX) null else page - 1,
                nextKey = if (result.isEmpty()) null else page + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return null
    }
}