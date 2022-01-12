package ru.coolhabit.firstapp.domain

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.coolhabit.firstapp.data.API
import ru.coolhabit.firstapp.data.MainRepository
import ru.coolhabit.firstapp.data.TmdbApi
import ru.coolhabit.firstapp.data.entity.TmdbResultsDto
import ru.coolhabit.firstapp.utils.Converter
import ru.coolhabit.firstapp.viewmodel.HomeFragmentViewModel

class Interactor(val repo: MainRepository, private val retrofitService: TmdbApi) {
    //В конструктор мы будем передавать коллбэк из вью модели, чтобы реагировать на то, когда фильмы будут получены
    //и страницу, которую нужно загрузить (это для пагинации)
    fun getFilmsFromApi(page: Int, callback: HomeFragmentViewModel.ApiCallback) {
        retrofitService.getFilms(API.KEY, "ru-RU", page).enqueue(object : Callback<TmdbResultsDto> {
            override fun onResponse(call: Call<TmdbResultsDto>, response: Response<TmdbResultsDto>) {
                //При успехе мы вызываем метод передаем onSuccess и в этот коллбэк список фильмов
                callback.onSuccess(Converter.convertApiListToDtoList(response.body()?.tmdbFilms))
            }

            override fun onFailure(call: Call<TmdbResultsDto>, t: Throwable) {
                //В случае провала вызываем другой метод коллбека
                callback.onFailure()
            }
        })
    }
}