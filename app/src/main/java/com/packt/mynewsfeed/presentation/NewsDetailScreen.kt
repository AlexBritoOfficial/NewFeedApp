package com.packt.mynewsfeed.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.packt.mynewsfeed.model.Result

@Composable
fun NewsDetailScreen(modifier: Modifier = Modifier,
                     viewModel: NewsFeedViewModel = hiltViewModel(),
                     result: Result?){

    Column {

        // News Title
        Text(text = result!!.title)

        Spacer(modifier = Modifier.width(8.dp))

        // News Content
        Text(text = result!!.content)


        // News Image
        /** Avatar **/
        Avatar(
            imageUrl = result!!.image_url,
            size = 50.dp,
            contentDescription = "${result!!.title}'s avatar"
        )
    }
}