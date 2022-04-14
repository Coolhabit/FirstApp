package ru.coolhabit.firstapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.coolhabit.firstapp.data.dao.FilmDao
import ru.coolhabit.firstapp.data.entity.Film

@Database(entities = [Film::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao
}