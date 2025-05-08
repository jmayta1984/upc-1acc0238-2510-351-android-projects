package pe.edu.upc.mealscompose.data.di

import androidx.room.Room
import pe.edu.upc.mealscompose.MealApplication
import pe.edu.upc.mealscompose.data.local.AppDatabase
import pe.edu.upc.mealscompose.data.local.MealDao
import pe.edu.upc.mealscompose.data.remote.ApiConstants
import pe.edu.upc.mealscompose.data.remote.CategoryService
import pe.edu.upc.mealscompose.data.remote.MealService
import pe.edu.upc.mealscompose.data.repository.CategoryRepository
import pe.edu.upc.mealscompose.data.repository.FavoriteRepository
import pe.edu.upc.mealscompose.data.repository.MealRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataModule {

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getCategoryService(): CategoryService {
        return getRetrofit().create(CategoryService::class.java)
    }

    fun getCategoryRepository(): CategoryRepository {
        return CategoryRepository(getCategoryService())
    }

    private fun getMealService(): MealService {
        return getRetrofit().create(MealService::class.java)
    }

    private fun getMealDao(): MealDao {
        return getAppDatabase().mealDao()
    }

    private fun getAppDatabase(): AppDatabase {
        return Room.databaseBuilder(
            MealApplication.instance.applicationContext,
            AppDatabase::class.java,
            "meals-db"
        ).build()
    }

    fun getMealRepository(): MealRepository {
        return MealRepository(getMealService(), getMealDao())
    }

    fun getFavoriteRepository(): FavoriteRepository {
        return FavoriteRepository(getMealDao())
    }
}