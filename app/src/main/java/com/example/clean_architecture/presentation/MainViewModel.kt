package com.example.clean_architecture.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import clean_architecture.domain.model.SaveUserNameModel
import clean_architecture.domain.usecase.GetUserNameUseCase
import clean_architecture.domain.usecase.SaveUserNameUseCase


class MainViewModel(
    private val saveUserNameUseCase: SaveUserNameUseCase,
    private val getUserNameUseCase: GetUserNameUseCase
) : ViewModel() {

    private val result = MutableLiveData<String>()
    val resultLiveData: LiveData<String> = result

    fun save(text: String) {
        val param = SaveUserNameModel(name = text)
        result.value = saveUserNameUseCase.execute(param = param).toString()

    }

    fun load() {
        result.value = getUserNameUseCase.execute().name
    }
}