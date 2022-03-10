package com.example.clean_architecture.data.storage.sharedpref

import com.example.clean_architecture.data.storage.model.UserModel

interface UserStorage {
    fun save(userModel: UserModel) : Boolean

    fun get(): UserModel
}