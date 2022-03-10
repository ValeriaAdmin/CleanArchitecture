package com.example.clean_architecture.presentation

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.clean_architecture.R
import com.example.clean_architecture.data.repository.UserRepositoryImp
import com.example.clean_architecture.data.storage.sharedpref.SharedPrefUserStorage
import com.example.clean_architecture.domain.model.SaveUserNameModel
import com.example.clean_architecture.domain.usecase.GetUserNameUseCase
import com.example.clean_architecture.domain.usecase.SaveUserNameUseCase

class MainActivity : Activity() {

    private val userStorage by lazy {SharedPrefUserStorage(context = application)}
    private val userRep by lazy { UserRepositoryImp(userStorege = userStorage)}
    private val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepository = userRep)}
    private val getUserNameUseCase by lazy {GetUserNameUseCase(userRepository = userRep)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editDataText)
        val textView = findViewById<TextView>(R.id.textView)
        val getDataBtn = findViewById<Button>(R.id.getDataBtn)
        val saveDataBtn = findViewById<Button>(R.id.saveDataBtn)

        saveDataBtn.setOnClickListener{
            val text = editText.text.toString();
            val param = SaveUserNameModel(name = text)
            textView.text = saveUserNameUseCase.execute(param = param).toString()

        }
        getDataBtn.setOnClickListener {
            textView.text = getUserNameUseCase.execute().name
        }
    }
}