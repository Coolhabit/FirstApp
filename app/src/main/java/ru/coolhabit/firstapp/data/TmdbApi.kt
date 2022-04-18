package ru.coolhabit.firstapp.data

import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.coolhabit.firstapp.data.entity.TmdbResults

private const val CATEGORY = "category"
private const val API_KEY = "api_key"
private const val LANGUAGE = "language"
private const val PAGE = "page"
private const val QUERY = "query"



interface TmdbApi {
    @GET("3/movie/{category}")
    fun getFilms(
        @Path(CATEGORY) category: String,
        @Query(API_KEY) apiKey: String,
        @Query(LANGUAGE) language: String,
        @Query(PAGE) page: Int
    ): Call<TmdbResults>

    @GET("3/search/movie")
    fun getFilmFromSearch(
        @Query(API_KEY) apiKey: String,
        @Query(LANGUAGE) language: String,
        @Query(QUERY) query: String,
        @Query(PAGE) page: Int
    ): Observable<TmdbResults>
}