package com.example.mad

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NewMeetingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_meeting)

        val cancelButton = findViewById<TextView>(R.id.cancelButton)
        val switchVideo = findViewById<Switch>(R.id.switchVideo)
        val switchPMI = findViewById<Switch>(R.id.switchPMI)
        val startMeetingButton = findViewById<Button>(R.id.startMeetingButton)

        // Handle cancel button click
        cancelButton.setOnClickListener {
            finish() // Go back to the previous screen
        }

        // Handle start meeting button click
        startMeetingButton.setOnClickListener {
            val intent = Intent(this, SafeDrivingModeActivity::class.java)
            startActivity(intent)
        }

    }
}
