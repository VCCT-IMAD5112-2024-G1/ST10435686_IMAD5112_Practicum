package com.example.weatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DetailedView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)

        // MAKING THE CONNECTION BETWEEN THE TWO ACTIVITIES AND RECEIVING THE ARRAY INFORMATION + VARIABLE DECLARATION

        val days = intent.getStringArrayExtra("days")
        val minTemp = intent.getIntArrayExtra("minTemp")
        val maxTemp = intent.getIntArrayExtra("maxTemp")
        val condition = intent.getStringArrayExtra("condition")

        var strOutput = "Min Temp    Max Temp    Condition\n"
        var counter = 0

        // PROCESSING FOR THE FORMAT OF THE OUTPUT

        while (counter < 7) {

            strOutput = strOutput + days?.get(counter).toString() + " \n" + minTemp?.get(counter).toString() + "   " + maxTemp?.get(counter).toString() + "   " + condition?.get(counter) + "\n"
            counter++
        }

        var viewDetailed = findViewById<TextView>(R.id.textViewDetailInfo)
        viewDetailed.setText(strOutput)

        // BUTTON TO TAKE YOU BACK TO THE MAIN SCREEN

        val mainMenuButton2 = findViewById<Button>(R.id.btnMainMenu2)
        mainMenuButton2.setOnClickListener{

            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
        }
    }
}