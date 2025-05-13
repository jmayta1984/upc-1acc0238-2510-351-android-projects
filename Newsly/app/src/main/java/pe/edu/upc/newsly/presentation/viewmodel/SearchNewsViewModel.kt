package pe.edu.upc.newsly.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upc.newsly.data.repository.NewsRepository
import pe.edu.upc.newsly.domain.model.News

class SearchNewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    private val _news = MutableStateFlow<List<News>>(emptyList())
    val news: StateFlow<List<News>> = _news

    fun searchNews(description: String) {
        viewModelScope.launch {
            _news.value = newsRepository.searchNews(description)
        }
    }

    fun insertNews(news: News) {
        viewModelScope.launch {
            newsRepository.insertNews(news)
        }
    }

    fun deleteNews(news: News) {
        viewModelScope.launch {
            newsRepository.deleteNews(news)
        }
    }
}