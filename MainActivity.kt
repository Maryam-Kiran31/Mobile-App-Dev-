//package com.example.mad
//import com.google.firebase.FirebaseApp
//import android.util.Log
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Button
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//import com.example.mad.databinding.MainActivityBinding
//import com.google.firebase.auth.FirebaseAuth
//
//class MainActivity : AppCompatActivity() {
//
//    private lateinit var binding:MainActivityBinding
//    companion object{
//        lateinit var auth:FirebaseAuth
//    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        auth=FirebaseAuth.getInstance()
//
//
//        setContentView(R.layout.main_activity)
//
//        // Displaying a welcome message to the user
//       // val welcomeTextView = findViewById<TextView>(R.id.welcomeTextView)
//       // welcomeTextView.text = "Welcome to your account!" // You can update this with user-specific data
//
//        // Set up the button to navigate to JoinMeetingActivity
//        val joinMeetingButton = findViewById<Button>(R.id.join_meeting_button)
//        joinMeetingButton.setOnClickListener {
//            val intent = Intent(this, JoinMeetingActivity::class.java)
//            intent.putExtra("MEETING_ID", "12345") // Pass any required data
//            startActivity(intent)
//        }
//
//        // Find the Sign Up button and set an OnClickListener
//        val signUpButton = findViewById<Button>(R.id.signup_button)
//        signUpButton.setOnClickListener {
//            // Start the SignUpActivity
//            val intent = Intent(this, SignupActivity::class.java)
//            startActivity(intent)
//        }
//
//        // Find the Sign Up button and set an OnClickListener
//        val signInButton = findViewById<Button>(R.id.signin_button)
//        binding.signinButton.setOnClickListener {
//            // Start the SignUpActivity
//            //val intent = Intent(this, SignInActivity::class.java)
//            //startActivity(intent)
//            startActivity(Intent(this, SignInActivity::class.java))
//            finish()
//        }
//
//        // Find the Settings button and set an OnClickListener
//        val settingsButton = findViewById<Button>(R.id.settings_button)
//        settingsButton.setOnClickListener {
//            val intent = Intent(this, SettingsActivity::class.java)
//            startActivity(intent)
//
//        }
//    }
//}
package com.example.mad

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.mad.databinding.MainActivityBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.FirebaseApp


class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    companion object {
        lateinit var auth: FirebaseAuth
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.joinMeetingButton.setOnClickListener {
            val intent = Intent(this, JoinMeetingActivity::class.java)
            intent.putExtra("MEETING_ID", "12345")
            startActivity(intent)
        }

        binding.signupButton.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        binding.signinButton.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }

        binding.settingsButton.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }
}
