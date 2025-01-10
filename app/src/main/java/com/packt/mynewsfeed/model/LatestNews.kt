package com.packt.mynewsfeed.model

data class LatestNews(
    val nextPage: String,
    val results: List<Result>,
    val status: String,
    val totalResults: Int
)