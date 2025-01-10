package com.packt.mynewsfeed.data

import com.packt.mynewsfeed.model.LatestNews
import com.packt.mynewsfeed.network.NewsFeedApiService
import retrofit2.Response
import javax.inject.Inject


class NetworkNewsFeedRepository @Inject constructor(private val newsFeedApi: NewsFeedApiService): NewsFeedRepository {

    override suspend fun getLatestNews(): Response<LatestNews> =  newsFeedApi.getLatestNews()
}

