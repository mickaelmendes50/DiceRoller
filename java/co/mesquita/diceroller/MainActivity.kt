package co.mesquita.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var leftDiceImage : ImageView
    lateinit var rightDiceImage : ImageView
    private var randomInt = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        leftDiceImage = findViewById(R.id.dice_image_left)
        rightDiceImage = findViewById(R.id.dice_image_right)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            rollDice(leftDiceImage)
            rollDice(rightDiceImage)
        }

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { reset() }
    }

    private fun rollDice(imageView: ImageView) {
        randomInt = (1..6).random()
        updateDiceImage(randomInt, imageView)
    }

    private fun reset() {
        leftDiceImage.setImageResource(R.drawable.empty_dice)
        rightDiceImage.setImageResource(R.drawable.empty_dice)
        randomInt = 0
    }

    private fun updateDiceImage(randomInt: Int, imageView: ImageView) {
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        imageView.setImageResource(drawableResource)
    }
}