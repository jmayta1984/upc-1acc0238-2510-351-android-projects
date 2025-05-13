package pe.edu.upc.newsly.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pe.edu.upc.newsly.domain.model.News

@Composable
fun NewsDetailView(
    news: News,
    toggleFavorite: (Boolean) -> Unit
) {
    val isFavorite = remember {
        mutableStateOf(news.isFavorite)
    }

    Column(modifier = Modifier.fillMaxSize()) {

        Box {
            AsyncImage(
                model = news.poster,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(384.dp),
                contentScale = ContentScale.Crop
            )
            IconButton(
                onClick = {
                    isFavorite.value = !isFavorite.value
                    news.isFavorite = isFavorite.value
                    toggleFavorite(isFavorite.value)
                },
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.White)
                    .size(36.dp)
                    .align(Alignment.TopEnd)
            ) {
                Icon(
                    if (isFavorite.value) {
                        Icons.Default.Favorite
                    } else {
                        Icons.Default.FavoriteBorder
                    },
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)


                )
            }
        }
        Column(Modifier.padding(8.dp)) {
            Text(news.title, fontWeight = FontWeight.Bold)
            Text(news.content)

        }
    }

}