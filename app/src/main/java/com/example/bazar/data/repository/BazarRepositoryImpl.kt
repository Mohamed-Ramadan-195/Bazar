package com.example.bazar.data.repository

import com.example.bazar.data.local.BazarDao
import com.example.bazar.data.remote.BazarApi
import com.example.bazar.domain.model.Item
import com.example.bazar.domain.repository.BazarRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class BazarRepositoryImpl (
    private val bazarDao: BazarDao,
    private val bazarApi: BazarApi
) : BazarRepository {
    override fun getBooksByCategory(category: String):  Flow<List<Item>> {
        return flow {
            val response = bazarApi.getBooksByCategory(category)
            emit(response.items)
        }.catch {
            emit(emptyList())
        }
    }

    override fun searchBooks(query: String): Flow<List<Item>> {
        return flow {
            val response = bazarApi.searchBooks(query)
            emit(response.items)
        }.catch {
            emit(emptyList())
        }
    }

    override suspend fun insertBook(item: Item) = bazarDao.insertItem(item)

    override suspend fun deleteBook(item: Item) = bazarDao.insertItem(item)

    override fun getBooksBookmarked(): Flow<List<Item>> = bazarDao.getBooksBookmarked()

    override suspend fun getBookDetails(id: String): Item = bazarDao.getBookDetails(id)
}