package com.amazingthings.diceroller

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var currentDrawable1 = 0
    var currentDrawable2 = 0
    lateinit var diceImage1 : ImageView
    lateinit var diceImage2 : ImageView
    lateinit var rollButton : Button
    lateinit var countButton : Button
    lateinit var resetButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage1 = findViewById(R.id.dice_image1)
        diceImage2 = findViewById(R.id.dice_image2)
        rollButton = findViewById(R.id.roll_button)
        countButton = findViewById(R.id.count_button)
        resetButton = findViewById(R.id.reset_button)

        rollButton.setOnClickListener { rollDice() }
        countButton.setOnClickListener{ countResult() }
        resetButton.setOnClickListener{ appReset() }
    }

    private fun rollDice() {

        var drawableResource: Int

        currentDrawable1 = (1..6).random()

        drawableResource = when (currentDrawable1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage1.setImageResource(drawableResource)

        currentDrawable2 = (1..6).random()

        drawableResource = when (currentDrawable2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage2.setImageResource(drawableResource)
    }

    private fun countResult() {

        var drawableResource: Int

        if (currentDrawable1 == 0 )
            currentDrawable1 = 1
        else if ( currentDrawable1 < 6 )
            currentDrawable1++

        drawableResource = when (currentDrawable1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage1.setImageResource(drawableResource)

        if (currentDrawable2 == 0 )
            currentDrawable2 = 1
        else if ( currentDrawable2 < 6 )
            currentDrawable2++

        drawableResource = when (currentDrawable2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage2.setImageResource(drawableResource)
    }

    private fun appReset() {
        currentDrawable1 = 1
        diceImage1.setImageResource(R.drawable.dice_1)
        currentDrawable2 = 1
        diceImage2.setImageResource(R.drawable.dice_1)
    }

}