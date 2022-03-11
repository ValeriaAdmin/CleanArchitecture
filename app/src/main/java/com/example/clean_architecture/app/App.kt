package com.example.clean_architecture.app

import android.app.Application
import com.example.clean_architecture.di.AppComponent
import com.example.clean_architecture.di.AppModul
import com.example.clean_architecture.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .appModul(AppModul(context = this))
            .build()
    }
}