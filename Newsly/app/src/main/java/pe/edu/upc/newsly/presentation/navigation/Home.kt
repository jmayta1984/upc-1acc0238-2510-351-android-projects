package pe.edu.upc.newsly.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.newsly.presentation.di.PresentationModule
import pe.edu.upc.newsly.presentation.view.SearchNewsView


@Composable
@Preview
fun Home() {
    val navController = rememberNavController()

    val navigationItems = listOf(
        NavigationItem(
            icon = Icons.Default.Search,
            title = "Search",
            route = "search_news"
        ),
        NavigationItem(
            icon = Icons.Default.Favorite,
            title = "Favorites",
            route = "favorites"
        )
    )

    val selectedIndex = remember {
        mutableStateOf(0)
    }

    val searchNewsViewModel = PresentationModule.getSearchNewsViewModel()

    Scaffold (
        bottomBar = {
            NavigationBar {
                navigationItems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedIndex.value == index,
                        icon = {
                            Icon(item.icon, contentDescription = null)
                        },
                        onClick = {
                            selectedIndex.value = index
                            navController.navigate(item.route)
                        },
                        label = {
                            Text(item.title)
                        }
                    )
                }
            }
        }

    ){ padding ->
        NavHost(
            navController,
            startDestination = "search_news",
            modifier = Modifier.padding(padding)
        ) {

            composable("search_news")
            {
                SearchNewsView(searchNewsViewModel)
            }
            composable("news_detail")
            { }
            composable("favorites")
            { }
        }
    }

}

data class NavigationItem(
    val icon: ImageVector,
    val title: String,
    val route: String
)