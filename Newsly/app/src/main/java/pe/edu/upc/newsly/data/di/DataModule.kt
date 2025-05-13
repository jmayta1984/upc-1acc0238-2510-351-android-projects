package pe.edu.upc.newsly.data.di

import pe.edu.upc.newsly.data.remote.ApiConstants
import pe.edu.upc.newsly.data.remote.NewsService
import pe.edu.upc.newsly.data.repository.NewsRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataModule {

    fun getNewsRepository(): NewsRepository {
        return NewsRepository(getNewsService())
    }

    fun getNewsService(): NewsService {
        return getRetrofit().create(NewsService::class.java)
    }

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}