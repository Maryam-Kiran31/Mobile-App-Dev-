package com.example.mad

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
        // Set default selected item
        bottomNavigationView.selectedItemId = R.id.navigation_meetings

        // Handle bottom navigation item clicks
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_meetings -> {

                }
                R.id.navigation_chat -> {
                    // Handle Team Chat tab click
                }
                R.id.navigation_mail -> {
                    // Handle Mail tab click
                }
                R.id.navigation_calendar -> {
                    // Handle Calendar tab click
                }
                R.id.navigation_more -> {
                    // Handle More tab click
                }
            }
            true
        }

        // Set up the click listener for the "New Meeting" image
        val newMeetingImageView = findViewById<ImageView>(R.id.imageViewNewMeeting)
        newMeetingImageView.setOnClickListener {
            // Start NewMeetingActivity when the image is clicked
            val intent = Intent(this, NewMeetingActivity::class.java)
            startActivity(intent)
        }
    }
}
