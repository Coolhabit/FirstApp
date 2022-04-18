package ru.coolhabit.firstapp

import android.app.Application
import ru.coolhabit.firstapp.di.AppComponent
import ru.coolhabit.firstapp.di.modules.DatabaseModule
import ru.coolhabit.firstapp.di.modules.DomainModule

class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        //Создаем компонент
        val remoteProvider = DaggerRemoteComponent.create()
        dagger = DaggerAppComponent.builder()
            .remoteProvider(remoteProvider)
            .databaseModule(DatabaseModule())
            .domainModule(DomainModule(this))
            .build()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}