package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    private lateinit var languageSpinner: Spinner
    private lateinit var btnHome: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
                    "Kotlin" -> navigateTo(KotlinActivity::class.java)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        btnHome.setOnClickListener {

        }
    }

    private fun navigateTo(languageActivity: Class<*>) {
        val intent = Intent(this, languageActivity)
        startActivity(intent)
    }
}