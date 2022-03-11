package com.example.clean_architecture.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.clean_architecture.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {


    private val vm by viewModel<MainViewModel>()

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