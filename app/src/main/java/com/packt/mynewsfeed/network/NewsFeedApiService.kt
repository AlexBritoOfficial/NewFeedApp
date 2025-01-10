package com.packt.mynewsfeed.network

import com.packt.mynewsfeed.model.LatestNews
import kotlinx.coroutines.flow.MutableStateFlow
import retrofit2.Response
import retrofit2.http.GET


// URL: https://newsdata.io/api/1/latest?apikey=pub_6426976e6e39c60ab41e0f65606cf535f0fd6

interface NewsFeedApiService {

    @GET("latest?apikey=pub_6426976e6e39c60ab41e0f65606cf535f0fd6&language=en&country=us&image=1")
    suspend fun getLatestNews(): Response<LatestNews>
}