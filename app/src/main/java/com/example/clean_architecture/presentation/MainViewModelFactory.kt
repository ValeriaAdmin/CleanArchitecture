package com.example.clean_architecture.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import clean_architecture.domain.usecase.GetUserNameUseCase
import clean_architecture.domain.usecase.SaveUserNameUseCase
import com.example.data.data.repository.UserRepositoryImp
import com.example.data.data.storage.sharedpref.SharedPrefUserStorage

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {
    private val userStorage: SharedPrefUserStorage by lazy {
        SharedPrefUserStorage(context = context)
    }
    private val userRep by lazy {
        UserRepositoryImp(userStorege = userStorage)
    }
    private val saveUserNameUseCase by lazy {
        SaveUserNameUseCase(userRepository = userRep)
    }
    private val getUserNameUseCase by lazy {
        GetUserNameUseCase(userRepository = userRep)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            saveUserNameUseCase = saveUserNameUseCase,
            getUserNameUseCase = getUserNameUseCase
        ) as T
    }
}