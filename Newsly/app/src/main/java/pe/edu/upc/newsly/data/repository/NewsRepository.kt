package pe.edu.upc.newsly.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.upc.newsly.data.remote.NewsService
import pe.edu.upc.newsly.domain.model.News

class NewsRepository(private val newsService: NewsService) {

    suspend fun searchNews(description: String) : List<News> = withContext(Dispatchers.IO) {
        val response = newsService.searchNews(description)
        if (response.isSuccessful) {
            response.body()?.let { it ->
                return@withContext it.map { newsResponse ->
                    newsResponse.toNews()
                }
            }
        }


        return@withContext emptyList()
    }
}