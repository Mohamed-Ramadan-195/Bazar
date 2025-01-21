package com.example.bazar.domain.usecase.book

import com.example.bazar.data.remote.dto.Item
import com.example.bazar.domain.repository.BazarRepository
import kotlinx.coroutines.flow.Flow

class GetBooksByCategoryUseCase (
    private val bazarRepository: BazarRepository
) {
    operator fun invoke(category: String): Flow<List<Item>> {
        return bazarRepository.getBooksByCategory(category)
    }

//    fun collectBooksByCategory(category: String) {
//        CoroutineScope(Dispatchers.IO).launch {
//            bazarRepository.getBooksByCategory(category).collect { books ->
//                books.forEach { book ->
//                    println("Book: ${book.volumeInfo.title}")
//                }
//            }
//        }
//    }
}