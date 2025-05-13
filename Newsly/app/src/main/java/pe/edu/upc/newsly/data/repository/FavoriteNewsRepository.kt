package pe.edu.upc.newsly.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.upc.newsly.data.local.NewsDao
import pe.edu.upc.newsly.data.model.NewsEntity
import pe.edu.upc.newsly.domain.model.FavoriteNews

class FavoriteNewsRepository(private val newsDao: NewsDao) {

    suspend fun fetchFavoriteNews(): List<FavoriteNews> = withContext(Dispatchers.IO) {
        return@withContext newsDao.fetchNews().map { entity ->
            entity.toFavoriteNews()
        }
    }

    suspend fun deleteFavoriteNews(news: FavoriteNews) = withContext(Dispatchers.IO) {
        newsDao.deleteNews(NewsEntity.fromFavoriteNews(news))
    }
}