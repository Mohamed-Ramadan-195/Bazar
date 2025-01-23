package com.example.bazar.di

import android.app.Application
import com.example.bazar.data.manager.LocalUserManagerImpl
import com.example.bazar.data.remote.BazarApi
import com.example.bazar.data.repository.BazarRepositoryImpl
import com.example.bazar.domain.manager.LocalUserManager
import com.example.bazar.domain.repository.BazarRepository
import com.example.bazar.domain.usecase.book.BooksUseCases
import com.example.bazar.domain.usecase.book.GetBooksByCategoryUseCase
import com.example.bazar.domain.usecase.book.SearchBooksUseCase
import com.example.bazar.domain.usecase.start.AppEntryUseCases
import com.example.bazar.domain.usecase.start.ReadAppEntryUseCase
import com.example.bazar.domain.usecase.start.SaveAppEntryUseCase
import com.example.bazar.util.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager (
        application: Application
    ) : LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases (
        localUserManager: LocalUserManager
    ) = AppEntryUseCases (
        saveAppEntryUseCase = SaveAppEntryUseCase(localUserManager),
        readAppEntryUseCase = ReadAppEntryUseCase(localUserManager)
    )

    @Provides
    @Singleton
    fun provideBookCategoriesUseCases (
        bazarRepository: BazarRepository
    ) : BooksUseCases {
        return BooksUseCases (
            getBooksByCategoryUseCase = GetBooksByCategoryUseCase(bazarRepository),
            searchBooksUseCase = SearchBooksUseCase(bazarRepository)
        )
    }

    @Provides
    @Singleton
    fun provideBazarApi(): BazarApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(BazarApi::class.java)
    }

    @Provides
    @Singleton
    fun provideBazarRepository (
        bazarApi: BazarApi
    ) : BazarRepository = BazarRepositoryImpl (
        bazarApi = bazarApi
    )
}