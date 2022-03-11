package com.example.clean_architecture.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import clean_architecture.domain.usecase.GetUserNameUseCase
import clean_architecture.domain.usecase.SaveUserNameUseCase


class MainViewModelFactory(
    val saveUserNameUseCase: SaveUserNameUseCase,
    val getUserNameUseCase: GetUserNameUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            saveUserNameUseCase = saveUserNameUseCase,
            getUserNameUseCase = getUserNameUseCase
        ) as T
    }
}