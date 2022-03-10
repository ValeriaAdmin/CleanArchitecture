package com.example.clean_architecture.data.repository

import android.content.Context
import com.example.clean_architecture.domain.model.SaveUserNameModel
import com.example.clean_architecture.domain.model.UserName
import com.example.clean_architecture.domain.repository.UserRepository

private const val SHARED_PREF_NAME = "shared pref"
private const val PREFERENCES_NAME = "preferens name"
class UserRepositoryImp( context: Context): UserRepository {

    val sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);

    override fun saveName(saveNameParam: SaveUserNameModel) : Boolean{
        sharedPreferences.edit().putString(PREFERENCES_NAME, saveNameParam.name.toString()).apply()
        return saveNameParam.name.isNotEmpty()
    }

    override fun getName():UserName{
        val name = sharedPreferences.getString(PREFERENCES_NAME,"").toString()
        return UserName(name = name);
    }
}
