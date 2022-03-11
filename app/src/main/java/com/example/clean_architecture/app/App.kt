package com.example.clean_architecture.app

import android.app.Application
import com.example.clean_architecture.di.appModul
import com.example.clean_architecture.di.dataModul
import com.example.clean_architecture.di.domainModul
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class App : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(androidContext = this@App)
            modules(listOf(appModul, dataModul, domainModul))
        }
    }
}