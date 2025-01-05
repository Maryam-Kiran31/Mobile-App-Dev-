//package com.example.mad
//
//import android.content.Intent
//import android.os.Bundle
//import android.view.View
//import android.widget.Button
//import android.widget.EditText
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//
//class SignupActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_signup)
//
//        // Reference to the Continue button and EditText fields
//        val continueButton = findViewById<Button>(R.id.continue_button)
//        val birthYearInput = findViewById<EditText>(R.id.birth_year_input)
//
//        // Handle the "Continue" button click to gather birth year and navigate to email input
//        continueButton.setOnClickListener {
//            val birthYear = birthYearInput.text.toString()
//            if (birthYear.isNotEmpty()) {
//                // Show birth year in Toast for now
//                Toast.makeText(this, "Birth year: $birthYear", Toast.LENGTH_SHORT).show()
//
//                // Navigate to SignupActivityEmail to collect email
//                val intent = Intent(this, SignupActivityEmail::class.java)
//                startActivity(intent)
//
//            } else {
//                Toast.makeText(this, "Please enter your birth year", Toast.LENGTH_SHORT).show()
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

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val continueButton = findViewById<Button>(R.id.continue_button)
        val birthYearInput = findViewById<EditText>(R.id.birth_year_input)

        continueButton.setOnClickListener {
            val birthYear = birthYearInput.text.toString()
            if (birthYear.isNotEmpty()) {
                Toast.makeText(this, "Birth year: $birthYear", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SignupActivityEmail::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please enter your birth year", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

