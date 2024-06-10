package com.example.weatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DetailedView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)

        val mainMenuButton2 = findViewById<Button>(R.id.btnMainMenu2)
        mainMenuButton2.setOnClickListener{

            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
        }
    }
}