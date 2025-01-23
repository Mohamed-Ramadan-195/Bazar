package com.example.bazar.data.repository

import com.example.bazar.data.remote.BazarApi
import com.example.bazar.domain.model.Item
import com.example.bazar.domain.repository.BazarRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class BazarRepositoryImpl (
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

//    override fun getBookById(id: String): Item {
//        return bazarApi.getBookById(id)
//    }
}