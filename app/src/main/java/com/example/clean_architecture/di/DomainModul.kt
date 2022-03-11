package com.example.clean_architecture.di

import clean_architecture.domain.usecase.GetUserNameUseCase
import clean_architecture.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module

val domainModul = module {

    //каждый раз создается новый объект, без сохранения
    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }

    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }
}