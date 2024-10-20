package com.example.zoom

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MeetingActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meeting)

        // Mute Button Logic
        val muteButton = findViewById<Button>(R.id.mute_button)
        muteButton.setOnClickListener {
            // Logic to mute/unmute audio (you can extend this functionality)
            muteButton.text = if (muteButton.text == "Mute") "Unmute" else "Mute"
        }

        // End Meeting Button Logic
        val endMeetingButton = findViewById<Button>(R.id.end_meeting_button)
        endMeetingButton.setOnClickListener {
            // Logic to end the meeting and finish the activity
            finish()  // This will end the current MeetingActivity
        }
    }
}
