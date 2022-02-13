package com.example.diceroller

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "MainActivity"




fun logging(){
    Log.v(TAG, "Hello, world!")
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        logging()

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            //Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
            rollDice()
            division()

        }

        Log.d("once", "this is the where app crashed before")
        findViewById<TextView>(R.id.division_textview).setText("deneme")


        Log.d("sonra","this should be logged if the bug is fixed")


    }

    fun division() {
        val numerator = 60
        var denominator = 4

        repeat(4) {
            Thread.sleep(3)


            Log.v("denominatoor:", "${numerator / denominator}")
            findViewById<TextView>(R.id.division_textview).setText("${denominator}")
            denominator--
        }
    }

    // Roll the dice and update the screen with the result
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()


        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.ic_launcher_background
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        //Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}