package com.example.zoomee

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var textViewUserProfile: TextView
    private lateinit var buttonStartMeeting: Button
    private lateinit var buttonSignout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Initialize the views
        textViewUserProfile = findViewById(R.id.textViewUserProfile)
        buttonStartMeeting = findViewById(R.id.buttonStartMeeting)
        buttonSignout = findViewById(R.id.buttonSignout)

        // Retrieve user email passed from LoginActivity or SignupActivity
        val userEmail = intent.getStringExtra("USER_EMAIL")

        // Display user profile information
        if (userEmail != null) {
            textViewUserProfile.text = "Welcome, $userEmail!"
        } else {
            textViewUserProfile.text = "Welcome, User!"
        }

        // Set click listener for "Start a Meeting"
        buttonStartMeeting.setOnClickListener {
            Toast.makeText(this, "Starting a meeting...", Toast.LENGTH_SHORT).show()
            // Add your logic to start a meeting here (e.g., opening a new activity)
        }

        // Set click listener for "Signout"
        buttonSignout.setOnClickListener {
            Toast.makeText(this, "Signing out...", Toast.LENGTH_SHORT).show()
            // Signout logic (e.g., redirect to login screen)
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Close the HomeActivity
        }
    }
}
