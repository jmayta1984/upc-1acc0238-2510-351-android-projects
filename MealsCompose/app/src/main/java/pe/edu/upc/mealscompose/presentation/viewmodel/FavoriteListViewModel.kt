package pe.edu.upc.mealscompose.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upc.mealscompose.data.repository.FavoriteRepository
import pe.edu.upc.mealscompose.domain.model.FavoriteMeal

class FavoriteListViewModel(val favoriteRepository: FavoriteRepository): ViewModel() {
    private val _favoriteMeals = MutableStateFlow<List<FavoriteMeal>>(emptyList())
    val favoriteMeals: StateFlow<List<FavoriteMeal>> = _favoriteMeals

    fun getFavoriteMeals() {
        viewModelScope.launch {
           _favoriteMeals.value = favoriteRepository.fetchAll()
        }
    }
}