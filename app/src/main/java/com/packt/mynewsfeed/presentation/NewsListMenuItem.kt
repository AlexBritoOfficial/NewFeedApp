package com.packt.mynewsfeed.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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

        /** Spacer **/
        /** Spacer **/
        Spacer(modifier = Modifier.width(8.dp))

        /** Column **/

        /** Column **/
        Row() {

            /** Avatar **/
            /** Avatar **/
            /** Avatar **/

            /** Avatar **/
            Avatar(
                imageUrl = result.image_url,
                size = 50.dp,
                contentDescription = "${result.title}'s avatar"
            )

            /** Conversation Name**/

            /** Conversation Name**/

            /** Conversation Name**/

            /** Conversation Name**/
            Text(
                text = result.title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(0.7f)
            )

            /** Conversation Maessage **/

            /** Conversation Maessage **/

            /** Conversation Maessage **/

            /** Conversation Maessage **/
            Text(text = result.content)
        }
    }
}