package com.example.weatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // MAIN MENU BUTTON

        val mainMenuButton = findViewById<Button>(R.id.btnMainMenu)
        mainMenuButton.setOnClickListener{

            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
        }
        // EXIT BUTTON (CLOSES APPLICATION

        val exitButton = findViewById<Button>(R.id.btnExit)
        exitButton.setOnClickListener{
            finishAffinity()
        }
    }
}