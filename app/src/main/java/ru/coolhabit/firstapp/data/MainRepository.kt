package ru.coolhabit.firstapp.data

import androidx.lifecycle.LiveData
import ru.coolhabit.firstapp.data.dao.FilmDao
import ru.coolhabit.firstapp.data.entity.Film
import java.util.concurrent.Executors


class MainRepository(private val filmDao: FilmDao) {

    fun putToDb(films: List<Film>) {
        //Запросы в БД должны быть в отдельном потоке
        Executors.newSingleThreadExecutor().execute {
            filmDao.insertAll(films)
        }
    }

    fun getAllFromDB(): LiveData<List<Film>> = filmDao.getCachedFilms()
}