package com.example.bazar.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.bazar.data.remote.BazarApi
import com.example.bazar.data.remote.BazarPagingSource
import com.example.bazar.data.remote.dto.category.Work
import com.example.bazar.domain.repository.BazarRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class BazarRepositoryImpl (
    private val bazarApi: BazarApi
) : BazarRepository {
    //    override suspend fun getBooksByCategory(category: String): Flow<List<Work>> {
//        return flow {
//            val remoteSubject = bazarApi.getBooksByCategory(category)
//
//            // Map the DTO data to the domain model
//            val works = remoteSubject.works.map { workDto ->
//                Work(
//                    authors = workDto.authors,
//                    availability = workDto.availability,
//                    cover_edition_key = workDto.cover_edition_key,
//                    cover_id = workDto.cover_id,
//                    edition_count = workDto.edition_count,
//                    first_publish_year = workDto.first_publish_year,
//                    has_fulltext = workDto.has_fulltext,
//                    ia = workDto.ia,
//                    ia_collection = workDto.ia_collection,
//                    key = workDto.key,
//                    lending_edition = workDto.lending_edition,
//                    lending_identifier = workDto.lending_identifier,
//                    lendinglibrary = workDto.lendinglibrary,
//                    printdisabled = workDto.printdisabled,
//                    public_scan = workDto.public_scan,
//                    subject = workDto.subject,
//                    title = workDto.title
//                )
//            }
//
//            // Emit the data
//            emit(works)
//        }.catch { e ->
//            // Handle errors, e.g., emit cached data or log error
//            println("Error fetching data: ${e.message}")
//        }
//    }

    override fun getBooksByCategory(category: String): Flow<PagingData<Work>> {
        return Pager (
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                BazarPagingSource(
                    bazarApi = bazarApi,
                    category = category
                )
            }
        ).flow
    }
}