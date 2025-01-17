package com.packt.mynewsfeed.di

import com.packt.mynewsfeed.data.NetworkNewsFeedRepository
import com.packt.mynewsfeed.data.NewsFeedRepository
import com.packt.mynewsfeed.network.NewsFeedApiService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetwohmrkModule {

    private val BASE_URL = "https://newsdata.io/api/1/"


    @Provides
    @Singleton
    fun provideRetroFit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }


    @Provides
    @Singleton
    fun provideNewsFeedApiService(retrofit: Retrofit): NewsFeedApiService {
        return retrofit.create(NewsFeedApiService::class.java)
    }

}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindNewsFeedRepository(networkNewsFeedRepositoryImpl: NetworkNewsFeedRepository
    ): NewsFeedRepository
}