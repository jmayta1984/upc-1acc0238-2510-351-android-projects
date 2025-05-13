package pe.edu.upc.newsly.data.model

import pe.edu.upc.newsly.domain.model.News


data class NewsResponse(
    val author: String?,
    val title: String?,
    val content: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val source: SourceResponse?
) {
    fun toNews(): News {
        return News(
            author = author ?: "",
            title = title ?: "",
            poster = urlToImage ?: "",
            publishedAt = publishedAt ?: ""
        )
    }
}


data class SourceResponse(
    val id: String?,
    val name: String?
)