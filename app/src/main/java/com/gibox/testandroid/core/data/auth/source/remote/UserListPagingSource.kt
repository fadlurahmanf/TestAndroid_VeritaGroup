/*
 * Created by Muhamad Syafii
 * Monday, 04/04/2022
 * Copyright (c) 2022 by Gibox Digital Asia.
 * All Rights Reserve
 */

package com.gibox.testandroid.core.data.auth.source.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.gibox.testandroid.core.data.auth.source.remote.network.AuthService
import com.gibox.testandroid.core.data.auth.source.remote.response.DataItem
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_PAGE_INDEX = 1
@ExperimentalPagingApi
class UserListPagingSource(private val service: AuthService): PagingSource<Int, DataItem>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataItem> {
        val position = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = service.dataListUser(position)
            val products = response.data
            val nextKey = if (products.isEmpty()) {
                null
            } else {
                // initial load size = 3 * NETWORK_PAGE_SIZE
                // ensure we're not requesting duplicating items, at the 2nd request
                position + 1
            }
            LoadResult.Page(
                data = products,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, DataItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

}