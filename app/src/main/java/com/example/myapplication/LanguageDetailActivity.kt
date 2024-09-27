package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class LanguageDetailActivity : ComponentActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language_detail)

        val languageName: TextView = findViewById(R.id.languageName)
        val languageDescription: TextView = findViewById(R.id.languageDescription)
        val languageCodeSample: TextView = findViewById(R.id.languageCodeSample)
        val backButton: Button = findViewById(R.id.backButton)


        val name = intent.getStringExtra("language_name")
        val description = intent.getStringExtra("language_description")
        val codeSample = intent.getStringExtra("language_code_sample")


        languageName.text = name
        languageDescription.text = description
        languageCodeSample.text = codeSample

        backButton.setOnClickListener {
            finish()
        }
    }
}