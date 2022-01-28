package ru.coolhabit.firstapp.di

import dagger.Component
import ru.coolhabit.firstapp.di.modules.DatabaseModule
import ru.coolhabit.firstapp.di.modules.DomainModule
import ru.coolhabit.firstapp.di.modules.RemoteModule
import ru.coolhabit.firstapp.viewmodel.FavoritesFragmentViewModel
import ru.coolhabit.firstapp.viewmodel.HomeFragmentViewModel
import javax.inject.Singleton

@Singleton
@Component(
    //Внедряем все модули, нужные для этого компонента
    modules = [
        RemoteModule::class,
        DatabaseModule::class,
        DomainModule::class
    ]
)
interface AppComponent {
    //метод для того, чтобы появилось внедрение зависимости в HomeFragmentViewModel
    fun inject(homeFragmentViewModel: HomeFragmentViewModel)

    fun inject(favoritesFragmentViewModel: FavoritesFragmentViewModel)
}