package com.example.data.data.repository

import com.example.data.data.storage.model.UserModel
import com.example.data.data.storage.sharedpref.UserStorage
import clean_architecture.domain.model.SaveUserNameModel
import clean_architecture.domain.model.UserName
import clean_architecture.domain.repository.UserRepository


class UserRepositoryImp(private val userStorege: UserStorage) : UserRepository {

    override fun saveName(saveNameParam: SaveUserNameModel): Boolean {
        val user = mapToStorage(saveNameParam)
        return userStorege.save(user)
    }

    override fun getName(): UserName {
        return mapToDomain(userStorege.get())

    }
    private fun mapToDomain(user: UserModel): UserName{
        return UserName(name = user.name)
    }
    private fun mapToStorage(saveNameParam: SaveUserNameModel): UserModel{
        return UserModel(name = saveNameParam.name)
    }
}
