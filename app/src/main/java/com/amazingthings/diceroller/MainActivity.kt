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

        currentDrawable = (1..6).random()

        val drawableResource = when (currentDrawable) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val diceImage: ImageView = findViewById(R.id.dice_image)
        diceImage.setImageResource(drawableResource)
    }

    private fun countResult() {
        val diceImage: ImageView = findViewById(R.id.dice_image)

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
        val diceImage: ImageView = findViewById(R.id.dice_image)
        currentDrawable = 1
        diceImage.setImageResource(R.drawable.dice_1)
    }

}