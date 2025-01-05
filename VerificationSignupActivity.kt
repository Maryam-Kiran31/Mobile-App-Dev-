package com.example.mad

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class VerificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)

        // References to UI elements
        val codeDigit1 = findViewById<EditText>(R.id.codeDigit1)
        val codeDigit2 = findViewById<EditText>(R.id.codeDigit2)
        val codeDigit3 = findViewById<EditText>(R.id.codeDigit3)
        val codeDigit4 = findViewById<EditText>(R.id.codeDigit4)
        val codeDigit5 = findViewById<EditText>(R.id.codeDigit5)
        val codeDigit6 = findViewById<EditText>(R.id.codeDigit6)
        val continueButton = findViewById<Button>(R.id.continue_button)

        // Handle "Continue" button click
        continueButton.setOnClickListener {
            val code = codeDigit1.text.toString() + codeDigit2.text.toString() + codeDigit3.text.toString() +
                    codeDigit4.text.toString() + codeDigit5.text.toString() + codeDigit6.text.toString()

            if (code.length == 6) {
                // If code is valid, navigate to CreateAccountActivity
                val intent = Intent(this@VerificationActivity, CreateAccountActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this@VerificationActivity, "Please enter the 6-digit verification code", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
