package com.example.pract1c

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var diceImage: ImageView
    lateinit var diceImage2: ImageView
    lateinit var diceImage3: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //In tutorial this is needed but don't know what the use is.
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }
        val clearButton: Button = findViewById(R.id.clearBtn)
        clearButton.setOnClickListener { clear() }
    }
    private fun rollDice(){
        Toast.makeText(this, "Dice Rolled",
            Toast.LENGTH_SHORT).show()

        diceImage = findViewById(R.id.dice_image)
        diceImage.setImageResource(getRandomDiceImage())
        diceImage2= findViewById(R.id.dice_image2)
        diceImage2.setImageResource(getRandomDiceImage())
        diceImage3 = findViewById(R.id.dice_image3)
        diceImage3.setImageResource(getRandomDiceImage())
    }
    private fun clear(){
        diceImage.setImageResource(R.drawable.empty_dice)
        diceImage2.setImageResource(R.drawable.empty_dice)
        diceImage3.setImageResource(R.drawable.empty_dice)
    }


    private fun getRandomDiceImage() : Int
    {
        val randomInt = Random().nextInt(6) + 1
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        return drawableResource
    }
}
