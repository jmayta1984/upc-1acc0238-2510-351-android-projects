package pe.edu.upc.mealscompose.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.upc.mealscompose.data.local.MealDao
import pe.edu.upc.mealscompose.domain.model.FavoriteMeal

class FavoriteRepository(val mealDao: MealDao) {

    suspend fun fetchAll(): List<FavoriteMeal> = withContext(Dispatchers.IO){
       return@withContext mealDao.fetchMeals().map { mealEntity ->
           FavoriteMeal(id = mealEntity.id, name = mealEntity.name)
       }.toList()
    }
}