//package com.example.mad
//
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import com.example.mad.databinding.ActivitySigninBinding
//import com.example.mad.databinding.ActivitySuccessBinding
//import com.google.android.material.snackbar.Snackbar
//
//class SignInActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        val binding= ActivitySigninBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        supportActionBar?.title="SignIp"
//
//        val emailEditText = findViewById<EditText>(R.id.editTextEmail)
//        val passwordEditText = findViewById<EditText>(R.id.editTextPassword)
//        val signInButton = findViewById<Button>(R.id.buttonSignIn)
//
//        signInButton.setOnClickListener {
//            val email = emailEditText.text.toString()
//            val password = passwordEditText.text.toString()
//
//            // Validate user input
//            if (email.isEmpty()) {
//                Snackbar.make(signInButton, "Please enter your email", Snackbar.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
//
//            if (password.isEmpty()) {
//                Snackbar.make(signInButton, "Please enter your password", Snackbar.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
//
//            // Simulate authentication
//            if (email == "maryamkiran232@gmail.com" && password == "Maryam1234$") {
//                // Navigate to HomeActivity if authentication succeeds
//                val intent = Intent(this, HomeActivity::class.java)
//                startActivity(intent)
//                finish() // Optional: Close the current activity
//            } else {
//                // Show error for invalid credentials
//                Snackbar.make(signInButton, "Invalid email or password", Snackbar.LENGTH_SHORT).show()
//            }
//        }
//    }
//}
package com.example.mad

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        val emailEditText = findViewById<EditText>(R.id.editTextEmail)
        val passwordEditText = findViewById<EditText>(R.id.editTextPassword)
        val signInButton = findViewById<Button>(R.id.buttonSignIn)

        signInButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                // Sign in with Firebase
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Signed in successfully!", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, HomeActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, "Sign in failed: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
