package com.example.mad

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class JoinMeetingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_meeting)

        // Find the Join button and set an onClickListener
        val joinButton = findViewById<Button>(R.id.join_button)
        joinButton.setOnClickListener {
            // Navigate to the InMeetingActivity
            val intent = Intent(this, InMeetingActivity::class.java)
            startActivity(intent)
        }
    }
}
