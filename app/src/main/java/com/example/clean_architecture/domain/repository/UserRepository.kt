package com.example.clean_architecture.domain.repository

import com.example.clean_architecture.domain.model.SaveUserNameModel
import com.example.clean_architecture.domain.model.UserName

interface UserRepository {

    fun saveName(saveNameParam: SaveUserNameModel) : Boolean

    fun getName(): UserName
}