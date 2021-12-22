package ru.coolhabit.firstapp.domain

import ru.coolhabit.firstapp.data.MainRepository

class Interactor(val repo: MainRepository) {
    fun getFilmsDB(): List<Film> = MainRepository.filmsDataBase

}