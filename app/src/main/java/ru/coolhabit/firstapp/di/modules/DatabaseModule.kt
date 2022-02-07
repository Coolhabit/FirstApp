package ru.coolhabit.firstapp.di.modules

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.coolhabit.firstapp.data.MainRepository
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideRepository() = MainRepository()
}