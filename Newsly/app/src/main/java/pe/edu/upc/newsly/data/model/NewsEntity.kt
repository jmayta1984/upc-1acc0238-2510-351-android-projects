package pe.edu.upc.newsly.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import pe.edu.upc.newsly.domain.model.FavoriteNews
import pe.edu.upc.newsly.domain.model.News

@Entity(tableName = "news")
data class NewsEntity(
    @PrimaryKey
    val title: String,
    val author: String,
    val description: String,
    val poster: String

) {
    fun toFavoriteNews(): FavoriteNews {
        return FavoriteNews(
            title = title,
            poster = poster,
            author = author,
            description = description
        )
    }

    companion object {
        fun fromNews(news: News): NewsEntity {
            return NewsEntity(
                title = news.title,
                author = news.author,
                description = news.description,
                poster = news.poster
            )
        }

        fun fromFavoriteNews(news: FavoriteNews): NewsEntity {
            return NewsEntity(
                title = news.title,
                author = news.author,
                description = news.description,
                poster = news.poster
            )
        }


    }
}