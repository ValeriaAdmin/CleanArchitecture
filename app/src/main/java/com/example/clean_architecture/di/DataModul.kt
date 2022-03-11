package com.example.clean_architecture.di

import android.content.Context
import clean_architecture.domain.repository.UserRepository
import com.example.data.data.repository.UserRepositoryImp
import com.example.data.data.storage.sharedpref.SharedPrefUserStorage
import com.example.data.data.storage.sharedpref.UserStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModul {

    @Provides
    @Singleton
    fun provideUserStorage(@ApplicationContext context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    @Singleton
    fun provideUserRepositoryImp(userStorage: UserStorage): UserRepository {
        return UserRepositoryImp(userStorege = userStorage)
    }
}