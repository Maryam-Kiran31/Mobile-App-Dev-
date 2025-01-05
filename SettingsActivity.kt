package com.example.mad

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle

class SettingsActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Initialize DrawerLayout and NavigationView
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)

        // Set up the ActionBar toggle for opening/closing the drawer
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Enable the ActionBar to be a toggle to open/close the drawer
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        // Handle navigation item selection
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_meetings -> {
                    Toast.makeText(this, "Meetings selected", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_general -> {
                    Toast.makeText(this, "General selected", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_accessibility -> {
                    Toast.makeText(this, "Accessibility selected", Toast.LENGTH_SHORT).show()
                    true
                }
                // Handle other menu items similarly
                else -> false
            }
        }
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        // Open/close the drawer when the home button is pressed
        return if (item.itemId == android.R.id.home) {
            drawerLayout.openDrawer(androidx.core.view.GravityCompat.START)

            true
        } else super.onOptionsItemSelected(item)
    }
}
