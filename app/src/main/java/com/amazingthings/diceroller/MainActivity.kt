package com.amazingthings.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val countButton: Button = findViewById(R.id.count_button)
        countButton.setOnClickListener{ countResult() }

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener{ appReset() }
    }

    private fun rollDice() {
        val randomInt = (1..6).random()

        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()
    }

    private fun countResult() {
        val countResultText: TextView = findViewById(R.id.result_text)

        if ( countResultText.text == "Hello World!" )
            countResultText.text = "1"
        else if ( countResultText.text == "6" )
            countResultText.text = "6"
        else
            countResultText.text = (countResultText.text.toString().toInt() + 1).toString()
    }

    private fun appReset() {
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = "0"
    }

}