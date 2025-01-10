package com.packt.mynewsfeed.data

import com.packt.mynewsfeed.model.LatestNews
import retrofit2.Response


interface NewsFeedRepository {
    suspend fun getLatestNews(): Response<LatestNews>
}