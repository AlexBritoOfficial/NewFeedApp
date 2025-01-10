package com.packt.mynewsfeed.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.packt.mynewsfeed.R
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.packt.mynewsfeed.model.Result


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsFeedListScreen(
    modifier: Modifier = Modifier,
    onNewsFeedListItemClicked: (Result) -> Unit
) {

    val viewModel: NewsFeedViewModel = hiltViewModel()

    val countries = listOf("USA", "UK", "Brazil", "China")
    val categories = listOf("Business", "Crime", "Environment", "Education")
    val languages = listOf("English", "Spanish", "Portuguese", "French")

    var isCountryDropDownExpanded by remember { mutableStateOf(false) }
    var countrySelected by remember { mutableStateOf(countries[0]) }

    var isCategoryDropDownExpanded by remember { mutableStateOf(false) }
    var categorySelected by remember { mutableStateOf(categories[0]) }

    var isLanguagesDropDownExpanded by remember { mutableStateOf(false) }
    var languageSelected by remember { mutableStateOf(languages[0]) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(stringResource(R.string.news_feed_list_title)) })
        },
        content = { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                NewsFeedList(viewModel = viewModel, onNewsFeedItemClicked = onNewsFeedListItemClicked)
            }
        })
}

@Composable
fun Avatar(
    modifier: Modifier = Modifier,
    imageUrl: String,
    size: Dp,
    contentDescription: String? = "User avatar"
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = contentDescription,
        modifier = modifier
            .size(size)
            .clip(RectangleShape)
            .padding(end = 10.dp),
        contentScale = ContentScale.Crop
    )
}

@Preview(showBackground = true)
@Composable
fun NewsFeedsListPreview() {
//    NewsFeedList(viewModel = NewsFeedViewModel())
}