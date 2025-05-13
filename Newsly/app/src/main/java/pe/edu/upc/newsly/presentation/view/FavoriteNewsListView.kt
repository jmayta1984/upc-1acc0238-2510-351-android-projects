package pe.edu.upc.newsly.presentation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pe.edu.upc.newsly.presentation.viewmodel.FavoriteNewsListViewModel

@Composable
fun FavoriteNewsListView(viewModel: FavoriteNewsListViewModel) {

    val favoriteNews = viewModel.favoriteNews.collectAsState()
    viewModel.fetchFavoriteNews()
    LazyColumn {
        items(favoriteNews.value) { news ->
            Card (modifier = Modifier.padding(8.dp)) {
                Row  {
                    Text(news.title, modifier = Modifier.weight(1f))
                    IconButton(
                        onClick = {
                            viewModel.deleteFavoriteNews(news)
                        }
                    ) {
                        Icon(Icons.Default.Delete, contentDescription = null)
                    }
                }
            }
        }
    }

}