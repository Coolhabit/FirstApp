package ru.coolhabit.firstapp

import android.app.Application
import ru.coolhabit.firstapp.di.AppComponent
import ru.coolhabit.firstapp.di.DaggerAppComponent
import ru.coolhabit.firstapp.di.modules.DatabaseModule
import ru.coolhabit.firstapp.di.modules.DomainModule
import ru.coolhabit.firstapp.di.modules.RemoteModule

class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        //Создаем компонент
        dagger = DaggerAppComponent.builder()
            .remoteModule(RemoteModule())
            .databaseModule(DatabaseModule())
            .domainModule(DomainModule(this))
            .build()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}