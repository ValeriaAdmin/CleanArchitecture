package com.example.clean_architecture.di

import clean_architecture.domain.repository.UserRepository
import clean_architecture.domain.usecase.GetUserNameUseCase
import clean_architecture.domain.usecase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModul {

    @Provides
    fun provideSaveUserNameUseCase(userRep: UserRepository): SaveUserNameUseCase =
        SaveUserNameUseCase(userRepository = userRep)


    @Provides
    fun provideGetUserNameUseCase(userRep: UserRepository): GetUserNameUseCase =
        GetUserNameUseCase(userRepository = userRep)

}