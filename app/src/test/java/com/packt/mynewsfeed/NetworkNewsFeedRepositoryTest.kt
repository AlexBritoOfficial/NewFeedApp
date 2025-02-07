package com.packt.mynewsfeed

import com.packt.mynewsfeed.data.NetworkNewsFeedRepository
import com.packt.mynewsfeed.data.network.NewsFeedApiService
import com.packt.mynewsfeed.model.LatestNews
import com.packt.mynewsfeed.model.Result
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.verify
import retrofit2.Response

class NetworkNewsFeedRepositoryTest {

    @Mock
    lateinit var newsFeedApiService: NewsFeedApiService

    private lateinit var networkNewsFeedRepository: NetworkNewsFeedRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        newsFeedApiService = mock(NewsFeedApiService::class.java)
        networkNewsFeedRepository = NetworkNewsFeedRepository(newsFeedApiService)
    }

    @Test
    fun `test getLatestNews with suspend fun`(): Unit = runBlocking {

        `when`(networkNewsFeedRepository.getLatestNews()).thenReturn(
            LatestNews(
                "", listOf(
                    Result(
                        ai_org = "",
                        ai_region = "",
                        ai_tag = "",
                        article_id = "",
                        category = listOf(""),
                        content = "",
                        country = listOf(""),
                        creator = listOf(""),
                        description = "",
                        duplicate = false,
                        image_url = "",
                        keywords = listOf(""),
                        language = "",
                        link = "",
                        pubDate = "",
                        pubDateTZ = "",
                        sentiment = "",
                        sentiment_stats = "",
                        source_icon = "",
                        source_id = "",
                        source_name = "",
                        source_priority = 1,
                        source_url = "",
                        title = "",
                        video_url = ""
                    )
                ), "", 1
            )
        )

        val result = networkNewsFeedRepository.getLatestNews()

        assert(result == LatestNews(
            "", listOf(
                Result(
                    ai_org = "",
                    ai_region = "",
                    ai_tag = "",
                    article_id = "",
                    category = listOf(""),
                    content = "",
                    country = listOf(""),
                    creator = listOf(""),
                    description = "",
                    duplicate = false,
                    image_url = "",
                    keywords = listOf(""),
                    language = "",
                    link = "",
                    pubDate = "",
                    pubDateTZ = "",
                    sentiment = "",
                    sentiment_stats = "",
                    source_icon = "",
                    source_id = "",
                    source_name = "",
                    source_priority = 1,
                    source_url = "",
                    title = "",
                    video_url = ""
                )
            ), "", 1
        ))

        verify(newsFeedApiService).getLatestNews()
    }
}