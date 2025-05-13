package pe.edu.upc.newsly.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pe.edu.upc.newsly.domain.model.News
import pe.edu.upc.newsly.presentation.viewmodel.SearchNewsViewModel

@Composable
fun SearchNewsView(viewModel: SearchNewsViewModel) {

    val description = remember {
        mutableStateOf("")
    }

    val news = viewModel.news.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            value = description.value,
            onValueChange = { description.value = it },
            trailingIcon = {
                IconButton(
                    onClick = {
                        viewModel.searchNews(description.value)
                    }
                ) {
                    Icon(Icons.Default.Search, contentDescription = null)
                }
            }
        )
        LazyColumn {
            items(news.value) { news ->
                NewsListItemView(news)
            }
        }
    }
}

@Composable
fun NewsListItemView(news: News) {
    Card (modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)){
        Column {
            AsyncImage(
                model = news.poster,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(256.dp),
                contentScale = ContentScale.Crop
            )
            Column (modifier = Modifier.padding(8.dp)){
                Text(news.title, fontWeight = FontWeight.Bold, maxLines = 1)
                Text(news.author)

            }

        }
    }
}