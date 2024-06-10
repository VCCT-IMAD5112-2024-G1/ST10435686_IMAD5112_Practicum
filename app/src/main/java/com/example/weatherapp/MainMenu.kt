package com.example.weatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get

class MainMenu : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    var days = arrayOf<String>("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    var minTemp = arrayOf(17, 18, 22, 20, 18, 22, 20)
    var maxTemp = arrayOf(24, 29, 25, 26, 25, 29, 31)
    var condition = arrayOf<String>("Clear", "Clear", "Sunny", "Cloudy", "Cloudy", "Sunny", "Sunny")
    var counter = 0
    var strOutput = "Day   Min Temp    Max Temp    Condition"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        //BUTTON TO GO BACK TO SPLASH SCREEN

        val backButton = findViewById<Button>(R.id.btnBackToTitle)
        backButton.setOnClickListener{

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // BUTTON TO GO TO THE DETAILED INFO PAGE AS WELL AS REFLECT THE INFORMATION FROM THE ARRAY

        val detailedInfoButton = findViewById<Button   >(R.id.btnDetailedInfo)
        detailedInfoButton.setOnClickListener{

            val intent = Intent(this, DetailedView::class.java)
            intent.putExtra("days", days)
            intent.putExtra("minTemp", minTemp)
            intent.putExtra("maxTempt", maxTemp)
            intent.putExtra("condition", condition)
            startActivity(intent)

        }

        // POPULATING THE SPINNER WITH THE TEXT IN THE "DAYS" ARRAY

        val daySpinner = findViewById<Spinner>(R.id.spinnerDay)
        daySpinner.onItemSelectedListener = this

        val ad: ArrayAdapter<*> = ArrayAdapter<Any?>(this,android.R.layout.simple_spinner_item, days)

        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        daySpinner.adapter = ad

        // CALCULATION OF THE AVERAGE TEMPERATURE

        var iLowest = 0
        var iHighest = 0
        var tempAvg = 0

        while (counter < 7) {

            iLowest = iLowest + minTemp[counter]
            iHighest = iHighest + maxTemp[counter]

            counter++
        }

        tempAvg = ((iLowest/7)+(iHighest/7))/2

        val avgView = findViewById<TextView>(R.id.textViewAvgTemp)
        avgView.setText(tempAvg.toString())

        // CLEAR BUTTON CLEARING THE INFORMATION OUT OF THE ARRAY AND EDIT TEXTS

        val clearButton = findViewById<Button>(R.id.btnClear)
        clearButton.setOnClickListener{

            var intDay = daySpinner.selectedItemPosition

            minTemp[intDay] = 999
            maxTemp[intDay] = 999
            condition[intDay] = " "

            val edtLowestTemp = findViewById<EditText>(R.id.edtLowestTemp)
            edtLowestTemp.setText("")

            val edtHighestTemp = findViewById<EditText>(R.id.edtHighestTemp)
            edtHighestTemp.setText("")

            val edtCondition = findViewById<EditText>(R.id.edtWeatherType)
            edtCondition.setText("")

        }
        // UPDATE BUTTON REPOPULATING THE ARRAYS WITH THE PROVIDED INFO IN THE EDIT TEXTS AND RECALCULATING THE AVERAGE

        val updateButton = findViewById<Button>(R.id.btnUpdate)
        updateButton.setOnClickListener{

            var intDay = daySpinner.selectedItemPosition
            val edtLowestTemp = findViewById<EditText>(R.id.edtLowestTemp)
            val edtHighestTemp = findViewById<EditText>(R.id.edtHighestTemp)
            val edtCondition = findViewById<EditText>(R.id.edtWeatherType)
            var counter3 = 0

            minTemp[intDay] = edtLowestTemp.text.toString().toInt()
            maxTemp[intDay] = edtHighestTemp.text.toString().toInt()
            condition[intDay] = edtCondition.text.toString()

            var iLowest2 = 0
            var iHighest2 = 0
            var tempAvg2 = 0

            while (counter3 < 7) {

                iLowest2 = iLowest2 + minTemp[counter3]
                iHighest2 = iHighest2 + maxTemp[counter3]
                counter3++
            }

            tempAvg = ((iLowest/7)+(iHighest/7))/2

            val avgView2 = findViewById<TextView>(R.id.textViewAvgTemp)
            avgView2.setText(tempAvg.toString())

        }
    }
        // CLARITY FOR USER (TOAST MESSAGE POPS UP) AS WELL AS FILLING IN THE INFORMATION
        // INTO THE EDITS FROM THE RESPECTIVE ARRAYS
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(applicationContext,days[position] + " has been selected",Toast.LENGTH_LONG).show()

            val edtLowestTemp = findViewById<EditText>(R.id.edtLowestTemp)
           edtLowestTemp.setText(minTemp[position].toString())

            val edtHighestTemp = findViewById<EditText>(R.id.edtHighestTemp)
           edtHighestTemp.setText(maxTemp[position].toString())

            val edtCondition = findViewById<EditText>(R.id.edtWeatherType)
            edtCondition.setText(condition[position])


    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}
}