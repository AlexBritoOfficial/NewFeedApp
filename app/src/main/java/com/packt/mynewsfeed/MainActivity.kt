package com.packt.mynewsfeed

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.packt.mynewsfeed.navigation.MainNavigation
import com.packt.mynewsfeed.ui.theme.MyNewsFeedTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyNewsFeedTheme {
                val navHostController = rememberNavController()
                MainNavigation(navHostController = navHostController)
            }
        }
    }
}
