package com.packt.mynewsfeed.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.packt.mynewsfeed.NewsFeedApplication
import com.packt.mynewsfeed.data.NewsFeedRepository
import com.packt.mynewsfeed.model.LatestNews
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsFeedViewModel @Inject constructor(private val newsFeedRepository: NewsFeedRepository): ViewModel() {

    private var _latestNewsFeed = MutableStateFlow<LatestNews>(LatestNews("", emptyList(),"",0))
    val latestNews: StateFlow<LatestNews> = _latestNewsFeed.asStateFlow()


    init {
        fetchLatestNews()
    }

     fun fetchLatestNews(){
        viewModelScope.launch{
            val response = newsFeedRepository.getLatestNews()
            _latestNewsFeed.value = response.body()!!
        }
    }

//    companion object{
//        val Factory : ViewModelProvider.Factory = viewModelFactory {
//            initializer {
//                val application = (this[APPLICATION_KEY] as NewsFeedApplication)
//                val viewModel: NewsFeedViewModel = ViewModelProvider(application).get(NewsFeedViewModel::class.java)
//                viewModel
//            }
//        }
//    }
}