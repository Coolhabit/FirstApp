package ru.coolhabit.remote_module.entity

import com.google.gson.annotations.SerializedName

private const val ADULT = "adult"
private const val BACKDROP = "backdrop_path"
private const val GENRE = "genre_ids"
private const val ID = "id"
private const val LANGUAGE = "original_language"
private const val ORIG_TITLE = "original_title"
private const val OVERVIEW = "overview"
private const val POPULARITY = "popularity"
private const val POSTER = "poster_path"
private const val RELEASE = "release_date"
private const val TITLE = "title"
private const val VIDEO = "video"
private const val VOTE_AV = "vote_average"
private const val VOTE_C = "vote_count"


data class TmdbFilm(
    @SerializedName(ADULT)
    val adult: Boolean,
    @SerializedName(BACKDROP)
    val backdropPath: String,
    @SerializedName(GENRE)
    val genreIds: List<Int>,
    @SerializedName(ID)
    val id: Int,
    @SerializedName(LANGUAGE)
    val originalLanguage: String,
    @SerializedName(ORIG_TITLE)
    val originalTitle: String,
    @SerializedName(OVERVIEW)
    val overview: String,
    @SerializedName(POPULARITY)
    val popularity: Double,
    @SerializedName(POSTER)
    val posterPath: String,
    @SerializedName(RELEASE)
    val releaseDate: String,
    @SerializedName(TITLE)
    val title: String,
    @SerializedName(VIDEO)
    val video: Boolean,
    @SerializedName(VOTE_AV)
    val voteAverage: Double,
    @SerializedName(VOTE_C)
    val voteCount: Int
)
