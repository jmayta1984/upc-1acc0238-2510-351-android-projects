package pe.edu.upc.newsly.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upc.newsly.data.repository.FavoriteNewsRepository
import pe.edu.upc.newsly.domain.model.FavoriteNews

class FavoriteNewsListViewModel(private val favoriteNewsRepository: FavoriteNewsRepository) :
    ViewModel() {

    private val _favoriteNews = MutableStateFlow<List<FavoriteNews>>(emptyList())
    val favoriteNews: StateFlow<List<FavoriteNews>> = _favoriteNews

    fun fetchFavoriteNews() {
        viewModelScope.launch {
            _favoriteNews.value = favoriteNewsRepository.fetchFavoriteNews()
        }
    }

    fun deleteFavoriteNews(news: FavoriteNews) {
        viewModelScope.launch {
            favoriteNewsRepository.deleteFavoriteNews(news)
            fetchFavoriteNews()
        }
    }

}