package com.example.a2_eduplayapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class UserRoleSP : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var userRoleSpinner: Spinner
    private lateinit var saveButton: Button
    private lateinit var clearButton: Button
    private lateinit var usernameDisplayText: TextView
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var bgmSwitch: Switch
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_role_sp)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //going back to the home screen
        val profileBack : ImageButton = findViewById(R.id.profBackButton)
        profileBack.setOnClickListener {
            val intent = Intent(this, SubjectSelection::class.java)
            startActivity(intent)
        }

        // initialize all views
        usernameEditText = findViewById(R.id.usernameEditText)
        userRoleSpinner = findViewById(R.id.userRoleSpinner)
        saveButton = findViewById(R.id.saveButton)
        clearButton = findViewById(R.id.clearButton)
        usernameDisplayText = findViewById(R.id.usernameDisplayText)
        bgmSwitch = findViewById(R.id.bgmSwitch)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        // Setup spinner values
        val userRoles = arrayOf("Select Your UserRole", "Tutor", "Parent", "Educator", "Student")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, userRoles)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        userRoleSpinner.adapter = adapter

        // Restore saved data
        val savedName = sharedPreferences.getString("username", "")
        val savedRole = sharedPreferences.getString("role", "")

        if (!savedName.isNullOrEmpty() && !savedRole.isNullOrEmpty()) {
            usernameEditText.setText(savedName)
            userRoleSpinner.setSelection(userRoles.indexOf(savedRole))
            usernameDisplayText.text = "$savedName\n$savedRole"
        }

        // Save button logic
        saveButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val role = userRoleSpinner.selectedItem.toString()

            if (username.isBlank() || role == "Select Your UserRole") {
                Toast.makeText(this, "Please enter your name and select a role", Toast.LENGTH_SHORT).show()
            } else {
                sharedPreferences.edit().apply {
                    putString("username", username)
                    putString("role", role)
                    apply()
                }
                usernameDisplayText.text = "Name: $username\nRole: $role"
                Toast.makeText(this, "Your profile is saved", Toast.LENGTH_SHORT).show()
            }
        }

        // Clear button logic
        clearButton.setOnClickListener {
            usernameEditText.text.clear()
            userRoleSpinner.setSelection(0)
            usernameDisplayText.text = ""

            sharedPreferences.edit().clear().apply()
        }

        // setting MediaPlayer with music file
        mediaPlayer = MediaPlayer.create(this, R.raw.bgm_eduplay)
        if (mediaPlayer == null) {
            Toast.makeText(this, "Failed to load music", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        // Toggle music ON/OFF with switch
        bgmSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                mediaPlayer.start()
                Toast.makeText(this, "Music turned ON", Toast.LENGTH_SHORT).show()
            } else {
                mediaPlayer.pause()
                mediaPlayer.seekTo(0)
                Toast.makeText(this, "Music turned OFF", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Release MediaPlayer when activity is destroyed
    override fun onDestroy() {
        super.onDestroy()
        if (this::mediaPlayer.isInitialized && mediaPlayer.isPlaying) {
            mediaPlayer.stop()
        }
        if (this::mediaPlayer.isInitialized) {
            mediaPlayer.release()
        }
    }
}