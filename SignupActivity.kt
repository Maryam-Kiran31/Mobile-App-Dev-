package com.example.zoomee

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignupActivity : AppCompatActivity() {
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var editTextConfirmPassword: EditText
    private lateinit var buttonSignup: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // Initialize the views
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword)
        buttonSignup = findViewById(R.id.buttonSignup)

        // Set the click listener for the button
        buttonSignup.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()
            val confirmPassword = editTextConfirmPassword.text.toString()

            if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            } else {
                // Logic to register user
                Toast.makeText(this, "Signup Successful", Toast.LENGTH_SHORT).show()

                // Redirect to HomeActivity after successful signup
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("USER_EMAIL", email) // Pass user email to HomeActivity
                startActivity(intent)
                finish()
            }
        }

    }
}
