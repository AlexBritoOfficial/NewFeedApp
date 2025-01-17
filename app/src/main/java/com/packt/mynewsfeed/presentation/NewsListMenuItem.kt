package com.packt.mynewsfeed.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.packt.mynewsfeed.model.Result

@Composable
fun NewsListMenuItem(result: Result) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        /** Column **/


        ElevatedCard(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            )
        ) {
            Row {
                Avatar(
                    imageUrl = result.image_url,
                    size = 50.dp,
                    contentDescription = "${result.title}'s avatar"
                )

                Text(
                    text = result.title,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(0.7f)
                )

                Text(text = result.content)
            }

        }

    }
}