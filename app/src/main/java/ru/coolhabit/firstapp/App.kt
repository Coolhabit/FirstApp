package ru.coolhabit.firstapp

import android.app.Application
import ru.coolhabit.firstapp.di.AppComponent
import ru.coolhabit.firstapp.di.DaggerAppComponent

class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        //Создаем компонент
        dagger = DaggerAppComponent.create()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}