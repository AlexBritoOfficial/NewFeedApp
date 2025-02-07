import com.packt.mynewsfeed.data.NetworkNewsFeedRepository
import com.packt.mynewsfeed.data.network.NewsFeedApiService
import com.packt.mynewsfeed.model.LatestNews
import com.packt.mynewsfeed.model.Result
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import retrofit2.Response

class NetworkNewsFeedRepositoryTest {

    @Mock
    lateinit var newsFeedApiService: NewsFeedApiService

    private lateinit var networkNewsFeedRepository: NetworkNewsFeedRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        networkNewsFeedRepository = NetworkNewsFeedRepository(newsFeedApiService)
    }

    @Test
    fun `test getLatestNews with suspend fun`(): Unit = runBlocking {

        // Mock the API service call
        val mockResponse = LatestNews(
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

        // Mocking the call to `newsFeedApiService.getLatestNews()`
        `when`(newsFeedApiService.getLatestNews()).thenReturn(Response.success(mockResponse))

        // Call the method under test
        val result = networkNewsFeedRepository.getLatestNews()

        // Perform the assertion
        assert(result == mockResponse)

        // Verify that the API call was made
        verify(newsFeedApiService).getLatestNews()
    }
}
