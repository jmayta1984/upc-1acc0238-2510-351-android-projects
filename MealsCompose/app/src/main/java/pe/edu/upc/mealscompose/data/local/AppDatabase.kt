package pe.edu.upc.mealscompose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import pe.edu.upc.mealscompose.data.model.MealEntity

@Database(entities = [MealEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun mealDao(): MealDao
}