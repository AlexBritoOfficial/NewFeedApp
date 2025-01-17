package com.packt.mynewsfeed.presentation

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.packt.mynewsfeed.model.Result

@Composable
fun NewsFeedList(
    viewModel: NewsFeedViewModel = hiltViewModel(),
    onNewsFeedItemClicked: (Result) -> Unit
) {
    val latestNews by viewModel.latestNews.collectAsStateWithLifecycle()

    LazyColumn() {

        items(latestNews.results) { index ->

            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onNewsFeedItemClicked(index)
                }) {
                NewsListMenuItem(index)
            }
        }

    }
}