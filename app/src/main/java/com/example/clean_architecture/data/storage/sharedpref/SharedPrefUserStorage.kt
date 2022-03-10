package com.example.clean_architecture.data.storage.sharedpref

import android.content.Context
import com.example.clean_architecture.data.storage.model.UserModel



private const val SHARED_PREF_NAME = "shared pref"
private const val PREFERENCES_NAME = "preferens name"

class SharedPrefUserStorage(context: Context): UserStorage {

    val sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    override fun save(saveNameParam: UserModel) : Boolean{
        sharedPreferences.edit().putString(PREFERENCES_NAME, saveNameParam.name.toString()).apply()
        return true
    }

    override fun get(): UserModel {
        val name = sharedPreferences.getString(PREFERENCES_NAME,"").toString()
        return UserModel(name = name);
    }



}