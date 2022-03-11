package com.example.clean_architecture.presentation

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.clean_architecture.R
import com.example.data.data.repository.UserRepositoryImp
import com.example.data.data.storage.sharedpref.SharedPrefUserStorage
import clean_architecture.domain.model.SaveUserNameModel
import clean_architecture.domain.usecase.GetUserNameUseCase
import clean_architecture.domain.usecase.SaveUserNameUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editDataText)
        val textView = findViewById<TextView>(R.id.textView)
        val getDataBtn = findViewById<Button>(R.id.getDataBtn)
        val saveDataBtn = findViewById<Button>(R.id.saveDataBtn)

        vm.resultLiveData.observe(this) {
            textView.text = it
        }

        saveDataBtn.setOnClickListener {
            val text = editText.text.toString();
            vm.save(text)
        }
        getDataBtn.setOnClickListener {
            vm.load()
        }
    }
}