package pe.edu.upc.newsly.data.di

import androidx.room.Room
import pe.edu.upc.newsly.NewslyApplication
import pe.edu.upc.newsly.data.local.AppDatabase
import pe.edu.upc.newsly.data.local.NewsDao
import pe.edu.upc.newsly.data.remote.ApiConstants
import pe.edu.upc.newsly.data.remote.NewsService
import pe.edu.upc.newsly.data.repository.FavoriteNewsRepository
import pe.edu.upc.newsly.data.repository.NewsRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataModule {

    fun getFavoriteNewsRepository(): FavoriteNewsRepository {
        return FavoriteNewsRepository(getNewsDao())

    }
    fun getNewsRepository(): NewsRepository {
        return NewsRepository(getNewsService(), getNewsDao())
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

    fun getNewsDao(): NewsDao {
        return getAppDatabase().newsDao()
    }

    fun getAppDatabase(): AppDatabase {
        return Room.databaseBuilder(
            NewslyApplication.instance.applicationContext,
            AppDatabase::class.java,
            "news-db"
        ).build()
    }
}