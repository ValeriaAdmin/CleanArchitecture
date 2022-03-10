package com.example.clean_architecture.domain.usecase

import com.example.clean_architecture.domain.model.SaveUserNameModel
import com.example.clean_architecture.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameModel): Boolean{
       val oldName = userRepository.getName();
        if (oldName.name == param.name){
            return true
        }

        userRepository.saveName(saveNameParam = param)
        return param.name.isNotEmpty()
    }

}