package com.example.clean_architecture.di

import clean_architecture.domain.repository.UserRepository
import com.example.data.data.repository.UserRepositoryImp
import com.example.data.data.storage.sharedpref.SharedPrefUserStorage
import com.example.data.data.storage.sharedpref.UserStorage
import org.koin.dsl.module

val dataModul = module {
    //охраняется в течение всего периода
    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImp(userStorege = get())
    }

}