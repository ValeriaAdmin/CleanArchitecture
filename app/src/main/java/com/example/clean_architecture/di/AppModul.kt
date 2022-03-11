package com.example.clean_architecture.di

import android.content.Context
import clean_architecture.domain.usecase.GetUserNameUseCase
import clean_architecture.domain.usecase.SaveUserNameUseCase
import com.example.clean_architecture.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModul(val context: Context) {
    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideMainViewModelFactory(
        saveUserNameUseCase: SaveUserNameUseCase,
        getUserNameUseCase: GetUserNameUseCase
    ): MainViewModelFactory {

        return MainViewModelFactory(
            saveUserNameUseCase = saveUserNameUseCase,
            getUserNameUseCase = getUserNameUseCase
        )
    }

}