package com.example.bazar.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.bazar.data.remote.dto.category.Work

class BazarPagingSource (
    private val bazarApi: BazarApi,
    private val category: String
) : PagingSource<Int, Work>() {
    override fun getRefreshKey(state: PagingState<Int, Work>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    private var totalBooksCount = 0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Work> {
        val page = params.key ?: 1
        return try {
            val bazarResponse = bazarApi.getBooksByCategory(category = category)
            totalBooksCount += bazarResponse.works.size
            val books = bazarResponse.works.distinctBy { it.title }
            LoadResult.Page(
                data = books,
                nextKey = if (totalBooksCount == bazarResponse.work_count) null else page + 1,
                prevKey = null
            )
        } catch (ex: Exception) {
            ex.printStackTrace()
            LoadResult.Error (
                throwable = ex
            )
        }
    }
}