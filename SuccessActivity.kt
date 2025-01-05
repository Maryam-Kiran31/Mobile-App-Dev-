package com.example.mad

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mad.databinding.ActivitySuccessBinding

class SuccessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding=ActivitySuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)
    supportActionBar?.title="SignUp"
        // Reference to the "Get Started" button
        val getStartedButton = findViewById<Button>(R.id.getStartedButton)

        // Handle "Get Started" button click
        getStartedButton.setOnClickListener {
            // Show a message (optional)
            Toast.makeText(this, "Navigating to the main screen", Toast.LENGTH_SHORT).show()

            // Navigate to the main activity (for example, a home screen or dashboard)
            // Redirect to HomeActivity
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish() // Close this activity
        }
    }
}
