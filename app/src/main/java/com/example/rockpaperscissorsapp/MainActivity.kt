package com.example.rockpaperscissorsapp

import android.os.Bundle
import android.widget.CheckBox
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    Latent var checkB: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkB = findViewById<CheckBox(R.id.check)
        checkB.setOnCheckedChangeListener { compoundButton:
                                            CompoundButton, b: Boolean ->
            changeText(compoundButton, b)
        }

    }