package pe.edu.upc.newsly.presentation.di

import pe.edu.upc.newsly.data.di.DataModule
import pe.edu.upc.newsly.presentation.viewmodel.FavoriteNewsListViewModel
import pe.edu.upc.newsly.presentation.viewmodel.SearchNewsViewModel

object PresentationModule {
    fun getSearchNewsViewModel(): SearchNewsViewModel {
        return SearchNewsViewModel(DataModule.getNewsRepository())
    }

    fun getFavoriteNewsListViewModel(): FavoriteNewsListViewModel {
        return FavoriteNewsListViewModel(DataModule.getFavoriteNewsRepository())
    }
}