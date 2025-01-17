package com.packt.mynewsfeed.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.packt.mynewsfeed.model.Result

@Composable
fun NewsDetailScreen(
    modifier: Modifier = Modifier,
    result: Result?
) {

    Scaffold(contentColor = Color.LightGray) { innerPadding ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {

            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                )
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // News Title
                    Text(
                        text = result!!.title,
                        modifier = Modifier.padding(50.dp),
                        fontWeight = FontWeight.Bold
                    )

                    // News Content
                    Text(
                        text = result!!.description,
                        modifier = Modifier.padding(30.dp)
                    )


                    // News Image
                    /** Avatar **/
                    Avatar(
                        modifier = Modifier.padding(10.dp),
                        imageUrl = result!!.image_url,
                        size = 250.dp,
                        contentDescription = "${result!!.title}'s avatar"
                    )

                }
            }

        }
    }

}