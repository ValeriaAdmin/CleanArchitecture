package com.example.data.data.storage.sharedpref

import com.example.data.data.storage.model.UserModel

interface UserStorage {
    fun save(userModel: UserModel) : Boolean

    fun get(): UserModel
}