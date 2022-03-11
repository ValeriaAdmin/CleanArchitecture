package com.example.clean_architecture.di

import com.example.clean_architecture.presentation.MainActivity
import dagger.Component

@Component(modules = [AppModul::class, DomainModul::class, DataModul::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}