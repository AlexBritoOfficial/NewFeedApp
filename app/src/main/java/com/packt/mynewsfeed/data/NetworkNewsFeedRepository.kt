package com.packt.mynewsfeed.data

import com.packt.mynewsfeed.model.LatestNews
import com.packt.mynewsfeed.data.network.NewsFeedApiService
import retrofit2.Response
import javax.inject.Inject

/**
 *  Repository classes are responsible for the following tasks:
 *
 *  Exposing data to the rest of the app.
 *  Centralizing changes to the data.
 *  Resolving conflicts between multiple data sources.
 *  Abstracting sources of data from the rest of the app.
 *  Containing business logic.
 *
 * ***/

class NetworkNewsFeedRepository @Inject constructor(private val newsFeedApi: NewsFeedApiService): NewsFeedRepository {

    override suspend fun getLatestNews(): LatestNews? =  newsFeedApi.getLatestNews().body()
}

