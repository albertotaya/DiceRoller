package com.amazingthings.diceroller

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var currentDrawable = 0
    lateinit var diceImage : ImageView
    lateinit var rollButton : Button
    lateinit var countButton : Button
    lateinit var resetButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage = findViewById(R.id.dice_image)
        rollButton = findViewById(R.id.roll_button)
        countButton = findViewById(R.id.count_button)
        resetButton = findViewById(R.id.reset_button)

        rollButton.setOnClickListener { rollDice() }
        countButton.setOnClickListener{ countResult() }
        resetButton.setOnClickListener{ appReset() }
    }

    private fun rollDice() {

        currentDrawable = (1..6).random()

        val drawableResource = when (currentDrawable) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
    }

    private fun countResult() {

        if (currentDrawable == 0 )
            currentDrawable = 1
        else if ( currentDrawable < 6 )
            currentDrawable++

        val drawableResource = when (currentDrawable) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
    }

    private fun appReset() {
        currentDrawable = 1
        diceImage.setImageResource(R.drawable.dice_1)
    }

}