package pe.edu.upc.jokescompose.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.upc.jokescompose.data.remote.ApiClient
import pe.edu.upc.jokescompose.data.repository.JokeRepository

@Preview
@Composable

fun JokeView() {

    val content = remember {
        mutableStateOf("")
    }

    val jokeService = ApiClient.getJokeService()
    val repository = JokeRepository(jokeService)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(content.value)
        IconButton(
            onClick = {
                repository.getRandomJoke {
                    it
                    content.value = it.content
                }
            }
        ) {
            Icon(Icons.Default.Refresh, contentDescription = null)

        }

    }
}