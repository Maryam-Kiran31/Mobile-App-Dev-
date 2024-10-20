package com.example.zoom

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // This should point to your XML layout

        // Reference the button with the correct ID
        val joinButton = findViewById<Button>(R.id.join_meeting_button)

        // Set click listener for the button
        joinButton.setOnClickListener {
            val intent = Intent(this, JoinMeetingActivity::class.java)
            startActivity(intent)
        }
    }
    // Load fragment method
    fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null) // Optional, adds back navigation
        transaction.commit()
    }
}
