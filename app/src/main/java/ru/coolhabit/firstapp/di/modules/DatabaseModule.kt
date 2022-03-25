package ru.coolhabit.firstapp.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.coolhabit.firstapp.data.MainRepository
import ru.coolhabit.firstapp.data.dao.FilmDao
import ru.coolhabit.firstapp.data.db.AppDatabase
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideFilmDao(context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "film_db"
        ).build().filmDao()

    @Provides
    @Singleton
    fun provideRepository(filmDao: FilmDao) = MainRepository(filmDao)
}