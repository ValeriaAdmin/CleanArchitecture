package com.example.clean_architecture.di

import android.content.Context
import clean_architecture.domain.repository.UserRepository
import com.example.data.data.repository.UserRepositoryImp
import com.example.data.data.storage.sharedpref.SharedPrefUserStorage
import com.example.data.data.storage.sharedpref.UserStorage
import dagger.Module
import dagger.Provides

@Module
class DataModul {

    @Provides
    fun provideUserStorage(context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImp(userStorege = userStorage)
    }


}