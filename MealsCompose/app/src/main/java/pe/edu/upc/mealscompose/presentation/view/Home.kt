package pe.edu.upc.mealscompose.presentation.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Home(){
    val navController = rememberNavController()
    val selectedCategory = remember {
        mutableStateOf<String?>(null)
    }

    NavHost(navController, startDestination = "Categories") {
        composable("Categories") {
            CategoryListView { category ->
                selectedCategory.value = category
                navController.navigate("Meals")
            }
        }

        composable("Meals") {
            selectedCategory.value?.let { it ->
                MealListView(category = it)
            }

        }
    }
}