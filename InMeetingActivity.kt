package com.example.mad

import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class InMeetingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_in_meeting)

        // Initialize video display area
        val videoDisplayArea = findViewById<FrameLayout>(R.id.video_display_area)

        // Meeting control buttons
        val muteButton = findViewById<Button>(R.id.mute_button)
        val videoButton = findViewById<Button>(R.id.video_button)
        val shareButton = findViewById<Button>(R.id.share_button)
        val participantsButton = findViewById<Button>(R.id.participants_button)
        val chatButton = findViewById<Button>(R.id.chat_button)
        val leaveButton = findViewById<Button>(R.id.leave_button)

        // Set button listeners
        muteButton.setOnClickListener {
            // Toggle mute functionality
            Toast.makeText(this, "Mute/Unmute clicked", Toast.LENGTH_SHORT).show()
        }

        videoButton.setOnClickListener {
            // Toggle video functionality
            Toast.makeText(this, "Start/Stop Video clicked", Toast.LENGTH_SHORT).show()
        }

        shareButton.setOnClickListener {
            // Share screen functionality
            Toast.makeText(this, "Share Screen clicked", Toast.LENGTH_SHORT).show()
        }

        participantsButton.setOnClickListener {
            // Show participants list
            Toast.makeText(this, "Participants clicked", Toast.LENGTH_SHORT).show()
        }

        chatButton.setOnClickListener {
            // Open chat
            Toast.makeText(this, "Chat clicked", Toast.LENGTH_SHORT).show()
        }

        leaveButton.setOnClickListener {
            // Leave the meeting
            Toast.makeText(this, "Leaving the meeting...", Toast.LENGTH_SHORT).show()
            finish() // End the activity
        }
    }
}
