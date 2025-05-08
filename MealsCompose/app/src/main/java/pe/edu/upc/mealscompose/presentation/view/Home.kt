package pe.edu.upc.mealscompose.presentation.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.mealscompose.presentation.model.NavigationItem

@Composable
fun Home(){
    val navController = rememberNavController()
    val selectedCategory = remember {
        mutableStateOf<String?>(null)
    }
    val navigationItemsList = listOf(
        NavigationItem (
            icon = Icons.Default.Home,
            title = "Categories",
            route = "Categories"
        ),
        NavigationItem (
            icon = Icons.Default.Favorite,
            title = "Favorites",
            route = "Favorites"
        ),


    )
    val selectedIndex = remember {
        mutableIntStateOf(0)
    }
    Scaffold(
        bottomBar = {
            NavigationBar {
                navigationItemsList.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedIndex.intValue == index,

                        onClick =  {
                            selectedIndex.intValue = index
                            navController.navigate(item.route)
                        },
                        label = {
                            Text(item.title)
                        },
                        icon = {
                            Icon(item.icon, contentDescription = item.title)
                        }
                    )
                }
            }
        }
    ) { padding ->
        NavHost(navController, startDestination = "Categories", modifier = Modifier.padding(padding)) {
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

            composable("Favorites") {
                FavoriteListView()
            }
        }
    }



}