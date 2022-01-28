package ru.coolhabit.firstapp.di.modules

import dagger.Module
import dagger.Provides
import ru.coolhabit.firstapp.data.MainRepository
import ru.coolhabit.firstapp.data.TmdbApi
import ru.coolhabit.firstapp.domain.Interactor
import javax.inject.Singleton

@Module
class DomainModule {
    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, tmdbApi: TmdbApi) = Interactor(repo = repository, retrofitService = tmdbApi)
}