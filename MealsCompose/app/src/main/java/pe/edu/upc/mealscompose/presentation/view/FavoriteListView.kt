package pe.edu.upc.mealscompose.presentation.view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pe.edu.upc.mealscompose.presentation.di.PresentationModule
import pe.edu.upc.mealscompose.presentation.viewmodel.FavoriteListViewModel

@Composable
fun FavoriteListView(favoriteListViewModel: FavoriteListViewModel = PresentationModule.getFavoriteListViewModel()) {
    val favoriteMeals = favoriteListViewModel.favoriteMeals.collectAsState()

    favoriteListViewModel.getFavoriteMeals()

    LazyColumn(modifier = Modifier.padding()) {
        items(favoriteMeals.value) {
            Card(modifier = Modifier.padding(8.dp)) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)) {
                    Text(it.name)

                }

            }
        }
    }
}
