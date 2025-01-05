//package com.example.mad
//
//import android.content.Intent
//import android.os.Bundle
//import android.text.Editable
//import android.text.TextWatcher
//import android.widget.Button
//import android.widget.EditText
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//
//class CreateAccountActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_create_account)
//
//        val firstNameEditText = findViewById<EditText>(R.id.firstName)
//        val lastNameEditText = findViewById<EditText>(R.id.lastName)
//        val passwordEditText = findViewById<EditText>(R.id.password)
//        val createAccountButton = findViewById<Button>(R.id.createAccountButton)
//
//        // Enable the button only when all fields are valid
//        val textWatcher = object : TextWatcher {
//            override fun afterTextChanged(s: Editable?) {
//                val firstName = firstNameEditText.text.toString()
//                val lastName = lastNameEditText.text.toString()
//                val password = passwordEditText.text.toString()
//
//                createAccountButton.isEnabled = validatePassword(password) && firstName.isNotEmpty() && lastName.isNotEmpty()
//                // Update the button's color
//                createAccountButton.setBackgroundColor(
//                    if (createAccountButton.isEnabled) resources.getColor(R.color.blue)
//                    else resources.getColor(R.color.grey)
//                )
//            }
//
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
//        }
//
//        firstNameEditText.addTextChangedListener(textWatcher)
//        lastNameEditText.addTextChangedListener(textWatcher)
//        passwordEditText.addTextChangedListener(textWatcher)
//
//        createAccountButton.setOnClickListener {
//            if (createAccountButton.isEnabled) {
//                // Proceed with creating account (save data, etc.)
//                // For now, we just show a toast
//
//                // Show a success message
//                Toast.makeText(this, "Account created successfully!", Toast.LENGTH_SHORT).show()
//
//                // Navigate to the Success Activity
//                val intent = Intent(this@CreateAccountActivity, SuccessActivity::class.java)
//                startActivity(intent)
//                finish() // Optionally, finish the current activity so the user can't go back
//            } else {
//                Toast.makeText(this, "Please fill all fields correctly", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//
//    // Validate the password based on the criteria
//    private fun validatePassword(password: String): Boolean {
//        val hasUpperCase = password.any { it.isUpperCase() }
//        val hasLowerCase = password.any { it.isLowerCase() }
//        val hasDigit = password.any { it.isDigit() }
//        val isValidLength = password.length >= 8
//
//        return hasUpperCase && hasLowerCase && hasDigit && isValidLength
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

class CreateAccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        val firstNameEditText = findViewById<EditText>(R.id.firstName)
        val lastNameEditText = findViewById<EditText>(R.id.lastName)
       // val passwordEditText = findViewById<EditText>(R.id.password)
        val createAccountButton = findViewById<Button>(R.id.createAccountButton)

        val textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val firstName = firstNameEditText.text.toString()
                val lastName = lastNameEditText.text.toString()
               // val password = passwordEditText.text.toString()

//                createAccountButton.isEnabled = validatePassword(password) && firstName.isNotEmpty() && lastName.isNotEmpty()
//                createAccountButton.setBackgroundColor(
//                    if (createAccountButton.isEnabled) resources.getColor(R.color.blue)
//                    else resources.getColor(R.color.grey)
//                )
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }

        firstNameEditText.addTextChangedListener(textWatcher)
        lastNameEditText.addTextChangedListener(textWatcher)
       // passwordEditText.addTextChangedListener(textWatcher)

        createAccountButton.setOnClickListener {
            if (createAccountButton.isEnabled) {
                Toast.makeText(this, "Account created successfully!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@CreateAccountActivity, SuccessActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Please fill all fields correctly", Toast.LENGTH_SHORT).show()
            }
        }
    }

//    private fun validatePassword(password: String): Boolean {
//        val hasUpperCase = password.any { it.isUpperCase() }
//        val hasLowerCase = password.any { it.isLowerCase() }
//        val hasDigit = password.any { it.isDigit() }
//        val isValidLength = password.length >= 8
//
//        return hasUpperCase && hasLowerCase && hasDigit && isValidLength
//    }
}

