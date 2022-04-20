package ru.coolhabit.firstapp.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.coolhabit.firstapp.data.MainRepository
import ru.coolhabit.firstapp.data.shared.PreferenceProvider
import ru.coolhabit.firstapp.domain.Interactor
import ru.coolhabit.remote_module.TmdbApi
import javax.inject.Singleton

@Module
//Передаем контекст для SharedPreferences через конструктор
class DomainModule(val context: Context) {
    //Нам нужно контекст как-то провайдить, поэтому создаем такой метод
    @Provides
    fun provideContext() = context

    @Singleton
    @Provides
    //Создаем экземпляр SharedPreferences
    fun providePreferences(context: Context) = PreferenceProvider(context)

    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, tmdbApi: TmdbApi, preferenceProvider: PreferenceProvider) = Interactor(repo = repository, retrofitService = tmdbApi, preferences = preferenceProvider)
}