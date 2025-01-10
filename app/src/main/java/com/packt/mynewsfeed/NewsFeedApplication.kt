package com.packt.mynewsfeed

import android.app.Application
import com.packt.mynewsfeed.data.AppContainer
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NewsFeedApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}