package com.example.zoom

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class SignUpFragment : Fragment() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var signUpButton: Button
    private lateinit var signInTextView: TextView // Declare the TextView here

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_signup, container, false)

        emailEditText = view.findViewById(R.id.emailEditText)
        passwordEditText = view.findViewById(R.id.passwordEditText)
        signUpButton = view.findViewById(R.id.signUpButton)
        signInTextView = view.findViewById(R.id.signInTextView) // Initialize the TextView here

        signUpButton.setOnClickListener {
            signUp()
        }

        signInTextView.setOnClickListener {
            // Navigate back to the Sign In Fragment
            (activity as? MainActivity)?.loadFragment(SignInFragment())
        }
        return view
    }

    private fun signUp() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        // Perform sign-up logic (e.g., API call)
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(context, "Please enter your email and password", Toast.LENGTH_SHORT).show()
            return
        }

        // Example of success
        Toast.makeText(context, "Sign Up Successful", Toast.LENGTH_SHORT).show()
        // Navigate to the Home activity or desired screen
        val intent = Intent(activity, HomeActivity::class.java)
        startActivity(intent)
    }
}
