package com.example.inostudio_task.di

import com.example.inostudio_task.common.Constants
import com.example.inostudio_task.data.remote.FilmApi
import com.example.inostudio_task.data.repository.FilmRepositoryImpl
import com.example.inostudio_task.domain.repository.FilmRepository
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
    fun provideFilmApi(): FilmApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FilmApi::class.java)
    }

    @Provides
    @Singleton
    fun provideFilmRepository(api: FilmApi): FilmRepository {
        return FilmRepositoryImpl(api)
    }
}