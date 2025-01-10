package com.packt.mynewsfeed.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.packt.mynewsfeed.presentation.NewsDetailScreen
import com.packt.mynewsfeed.presentation.NewsFeedList
import com.packt.mynewsfeed.presentation.NewsFeedListScreen
import com.packt.mynewsfeed.model.Result

@Composable
fun MainNavigation(navHostController: NavHostController) {

    NavHost(navController = navHostController, startDestination = NavRoutes.NewsFeedList) {
        addNewsFeedList(navHostController)
        addDetailScreen(navHostController)
    }

}

fun NavGraphBuilder.addNewsFeedList(navController: NavController) {

    composable(route = NavRoutes.NewsFeedList) {
        NewsFeedListScreen (onNewsFeedListItemClicked = { result ->
            navController.navigate(route = NavRoutes.NewsFeedDetailScreen.replace("{newsItem}","${Uri.encode(Gson().toJson(result))}"))
        })
    }
}

fun NavGraphBuilder.addDetailScreen(navController: NavController) {

    composable(
        route = NavRoutes.NewsFeedDetailScreen,
        arguments = listOf(navArgument(NavRoutes.NewsArgs.NewsItem) { type = NavType.StringType })
    ) { backStackEntry ->

        val json = backStackEntry.arguments?.getString(NavRoutes.NewsArgs.NewsItem)
        val result = Gson().fromJson(json, Result::class.java)
        NewsDetailScreen(result = result)
    }
}