package pe.edu.upc.jokescompose.data.model

import com.google.gson.annotations.SerializedName

data class Joke(
    @SerializedName("value")
    val content: String
)
