package com.example.clean_architecture.di

import clean_architecture.domain.repository.UserRepository
import clean_architecture.domain.usecase.GetUserNameUseCase
import clean_architecture.domain.usecase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModul {

    @Provides
    fun provideSaveUserNameUseCase(userRep: UserRepository): SaveUserNameUseCase {
        return SaveUserNameUseCase(userRepository = userRep)
    }

    @Provides
    fun provideGetUserNameUseCase(userRep: UserRepository): GetUserNameUseCase {
        return GetUserNameUseCase(userRepository = userRep)
    }

}