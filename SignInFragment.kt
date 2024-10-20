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

class SignInFragment : Fragment() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var signInButton: Button
    private lateinit var signUpTextView: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_signin, container, false)

        emailEditText = view.findViewById(R.id.emailEditText)
        passwordEditText = view.findViewById(R.id.passwordEditText)
        signInButton = view.findViewById(R.id.signInButton)
        signUpTextView = view.findViewById(R.id.signUpTextView)

        signInButton.setOnClickListener {
            signIn()
        }

        signUpTextView.setOnClickListener {
            // Navigate to the Sign Up Fragment
            (activity as? MainActivity)?.loadFragment(SignUpFragment())
        }
        return view
    }

    private fun signIn() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        // Perform sign-in logic (e.g., API call)
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(context, "Please enter your email and password", Toast.LENGTH_SHORT).show()
            return
        }

        // Example of success
        Toast.makeText(context, "Sign In Successful", Toast.LENGTH_SHORT).show()
        // Navigate to the Home activity
        val intent = Intent(activity, HomeActivity::class.java)
        startActivity(intent)
    }
}
