package com.example.mysavefileapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.example.mysavefileapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val viewModel: MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.dataVM = viewModel
        binding.lifecycleOwner = this

        binding.etData.addTextChangedListener (object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.setSavingText(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })

        binding.buttonSave.setOnClickListener {
            MyFileSaver(this).writeToFile(viewModel.savedText.value.toString())
        }

        binding.buttonView.setOnClickListener {
            viewModel.setReadingText(MyFileSaver(this).readFromFile().toString())
        }
    }
}