package pe.edu.upc.newsly.domain.model

data class News (
    val author: String,
    val title: String,
    val poster: String,
    val publishedAt: String,
    val content: String,
    val source: String,
    val description: String,
    var isFavorite: Boolean = false
)