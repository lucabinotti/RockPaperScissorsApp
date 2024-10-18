package com.example.rockpaperscissorsapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rg = findViewById<RadioGroup>(R.id.choiceGroup)

        val playButton = findViewById<Button>(R.id.playButton)
        playButton.setOnClickListener {
            val selectedId = rg.checkedRadioButtonId

            if(selectedId != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectedId)
                val userMove: Move? = Move.getMove(selectedRadioButton.text.toString())

                if(userMove != null)
                {
                    val randomMove: Move = Move.getRandomMove()
                    if(userMove == randomMove)
                    {
                        Toast.makeText(this, getString(R.string.draw_message, randomMove.emoji), Toast.LENGTH_LONG).show()
                    }
                    else if(userMove.beats(randomMove))
                    {
                        Toast.makeText(this, getString(R.string.victory_message, randomMove.emoji), Toast.LENGTH_LONG).show()
                    }
                    else Toast.makeText(this, getString(R.string.defeat_message, randomMove.emoji), Toast.LENGTH_LONG).show()
                }
                else Log.e("null_move", "User move is null")

                rg.clearCheck()
            }
            else Toast.makeText(this, R.string.select_move, Toast.LENGTH_LONG).show()
        }
    }
}