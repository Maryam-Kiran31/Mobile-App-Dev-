//package com.example.mad
//
//import android.content.Intent
//import android.os.Bundle
//import android.view.View
//import android.widget.Button
//import android.widget.EditText
//import android.widget.TextView
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//
//class SignupActivityEmail : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_signup_email)
//
//
//        // References to UI elements
//        val emailInput = findViewById<EditText>(R.id.emailInput)
//        val continueButton = findViewById<Button>(R.id.continueButton)
//        val privacyStatement = findViewById<TextView>(R.id.privacyStatement)
//        val googleSignUpButton = findViewById<Button>(R.id.googleSignUpButton)
//        val appleSignUpButton = findViewById<Button>(R.id.appleSignUpButton)
//        val facebookSignUpButton = findViewById<Button>(R.id.facebookSignUpButton)
//
//        // Handle the "Continue" button click
//        continueButton.setOnClickListener { v: View? ->
//            val email = emailInput.text.toString()
//
//            // Check if the email is not empty and is valid
//            if (email.isNotEmpty()) {
//                // You can add a regex to validate the email format if needed
//                // Example: val emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"
//                // If email is valid, navigate to the verification screen
//                val intent = Intent(this@SignupActivityEmail, VerificationActivity::class.java)
//                intent.putExtra("email", email)  // Pass the email to VerificationActivity
//
//                // Start the VerificationActivity
//                startActivity(intent)
//            } else {
//                // Show error message if email is empty
//                Toast.makeText(this@SignupActivityEmail, "Please enter your email", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        // Handle Google Signup (for now, just a toast)
//        googleSignUpButton.setOnClickListener { v: View? ->
//            Toast.makeText(this@SignupActivityEmail, "Google SignUp clicked", Toast.LENGTH_SHORT).show()
//        }
//
//        // Handle Apple Signup (for now, just a toast)
//        appleSignUpButton.setOnClickListener { v: View? ->
//            Toast.makeText(this@SignupActivityEmail, "Apple SignUp clicked", Toast.LENGTH_SHORT).show()
//        }
//
//        // Handle Facebook Signup (for now, just a toast)
//        facebookSignUpButton.setOnClickListener { v: View? ->
//            Toast.makeText(this@SignupActivityEmail, "Facebook SignUp clicked", Toast.LENGTH_SHORT).show()
//        }
//    }
//}
package com.example.mad

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SignupActivityEmail : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_email)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        val emailInput = findViewById<EditText>(R.id.emailInput)
        val passwordInput = findViewById<EditText>(R.id.password)
        val continueButton = findViewById<Button>(R.id.continueButton)

        // Enable/Disable the continue button based on validation
        val textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val email = emailInput.text.toString().trim()
                val password = passwordInput.text.toString().trim()

                continueButton.isEnabled = email.isNotEmpty() && validatePassword(password)
                continueButton.setBackgroundColor(
                    if (continueButton.isEnabled) resources.getColor(R.color.blue)
                    else resources.getColor(R.color.grey)
                )
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }

        emailInput.addTextChangedListener(textWatcher)
        passwordInput.addTextChangedListener(textWatcher)

        continueButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (email.isNotEmpty() && validatePassword(password)) {
                // Create a new user with Firebase
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Account created successfully!", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, SuccessActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, "Sign up failed: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Please fill out all fields correctly", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Validate the password based on the criteria
    private fun validatePassword(password: String): Boolean {
        val hasUpperCase = password.any { it.isUpperCase() }
        val hasLowerCase = password.any { it.isLowerCase() }
        val hasDigit = password.any { it.isDigit() }
        val isValidLength = password.length >= 8

        return hasUpperCase && hasLowerCase && hasDigit && isValidLength
    }
}
