package com.example.bazar.di

import android.app.Application
import androidx.room.Room
import com.example.bazar.data.local.BazarDao
import com.example.bazar.data.local.BazarDatabase
import com.example.bazar.data.manager.LocalUserManagerImpl
import com.example.bazar.data.remote.api.BazarApi
import com.example.bazar.data.repository.BazarRepositoryImpl
import com.example.bazar.domain.manager.LocalUserManager
import com.example.bazar.domain.repository.BazarRepository
import com.example.bazar.domain.usecase.book.base.BooksUseCases
import com.example.bazar.domain.usecase.book.local.DeleteBookUseCase
import com.example.bazar.domain.usecase.book.local.GetBookDetailsUseCase
import com.example.bazar.domain.usecase.book.local.GetBooksBookmarkedUseCase
import com.example.bazar.domain.usecase.book.remote.GetBooksByCategoryUseCase
import com.example.bazar.domain.usecase.book.local.InsertBookUseCase
import com.example.bazar.domain.usecase.book.remote.GetBooksByTitleUseCase
import com.example.bazar.domain.usecase.book.remote.SearchBooksUseCase
import com.example.bazar.domain.usecase.start.AppEntryUseCases
import com.example.bazar.domain.usecase.start.ReadAppEntryUseCase
import com.example.bazar.domain.usecase.start.SaveAppEntryUseCase
import com.example.bazar.util.Constant
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
            searchBooksUseCase = SearchBooksUseCase(bazarRepository),
            insertBookUseCase = InsertBookUseCase(bazarRepository),
            deleteBookUseCase = DeleteBookUseCase(bazarRepository),
            getBooksBookmarkedUseCase = GetBooksBookmarkedUseCase(bazarRepository),
            getBookDetailsUseCase = GetBookDetailsUseCase(bazarRepository),
            getBooksByTitleUseCase = GetBooksByTitleUseCase(bazarRepository)
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
        bazarDao: BazarDao,
        bazarApi: BazarApi
    ) : BazarRepository = BazarRepositoryImpl (
        bazarDao = bazarDao,
        bazarApi = bazarApi
    )

    @Provides
    @Singleton
    fun provideBazarDatabase (
        application: Application
    ) : BazarDatabase {
        return Room
            .databaseBuilder (
                context = application,
                klass = BazarDatabase::class.java,
                name = Constant.BAZAR_DATABASE_NAME
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideBazarDao (bazarDatabase: BazarDatabase) = bazarDatabase.bazarDao
}