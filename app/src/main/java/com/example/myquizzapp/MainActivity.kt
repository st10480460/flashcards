package com.example.myquizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
 // Ensure this matches your XML file name EXACTLY

                // Get references to the views.  The IDs are accessed via R.id.your_id
                val welcomeText: TextView = findViewById(R.id.welcome_text)
                val startButton: Button = findViewById(R.id.start_button)

                // Set up any logic (e.g., a click listener for the button)
                startButton.setOnClickListener {
                    // Start the quiz activity, or perform other action
                    // For example:
                    val intent = Intent(this, Questions::class.java) // Corrected class name
                    startActivity(intent)
                }
            }
        }

