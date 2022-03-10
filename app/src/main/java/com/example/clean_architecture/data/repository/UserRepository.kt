package com.example.clean_architecture.data.repository

import com.example.clean_architecture.data.storage.model.UserModel
import com.example.clean_architecture.data.storage.sharedpref.UserStorage
import com.example.clean_architecture.domain.model.SaveUserNameModel
import com.example.clean_architecture.domain.model.UserName
import com.example.clean_architecture.domain.repository.UserRepository


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
