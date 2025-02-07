package com.packt.mynewsfeed.data

import com.packt.mynewsfeed.model.LatestNews


interface NewsFeedRepository {
    suspend fun getLatestNews(): LatestNews?
}