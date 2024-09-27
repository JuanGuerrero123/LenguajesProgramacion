package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.ComponentActivity

class KotlinActivity : ComponentActivity() {

    private lateinit var languageSpinner: Spinner
    private lateinit var btnHome: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        languageSpinner = findViewById(R.id.language_spinner)
        btnHome = findViewById(R.id.btn_home)

        val languages = listOf("Selecciona un lenguaje", "Python", "Java", "Kotlin")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        languageSpinner.adapter = adapter


        languageSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                when (languages[position]) {
                    "Python" -> navigateTo(PythonActivity::class.java)
                    "Java" -> navigateTo(JavaActivity::class.java)
                    "Kotlin" -> {} // Ya estamos en Kotlin
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }


        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun navigateTo(languageActivity: Class<*>) {
        val intent = Intent(this, languageActivity)
        startActivity(intent)
    }
}
