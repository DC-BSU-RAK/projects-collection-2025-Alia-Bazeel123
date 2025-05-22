package com.example.a2_eduplayapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScienceSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_science_selection)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //going to OUR BODY IDEAS screen
        val ourBodyButton : Button = findViewById(R.id.ourBodyButton)
        ourBodyButton.setOnClickListener {
            val intent = Intent(this, OurBodyIdea::class.java)
            startActivity(intent)
        }
        //going to WEATHER IDEAS screen
        val weatherButton : Button = findViewById(R.id.weatherButton)
        weatherButton.setOnClickListener {
            val intent = Intent(this, WeatherIdea::class.java)
            startActivity(intent)
        }
        //going to LIVING NON_LIVING IDEAS screen
        val livingNonButton : Button = findViewById(R.id.livingNonButton)
        livingNonButton.setOnClickListener {
            val intent = Intent(this, LivingNonIdea::class.java)
            startActivity(intent)
        }
        //going back to the HOME screen
        val backToSubButton3 : ImageButton = findViewById(R.id.backToSubButton3)
        backToSubButton3.setOnClickListener {
            val intent = Intent(this, SubjectSelection::class.java)
            startActivity(intent)
        }
        //going to the PROFILE screen
        val profButton3 : ImageButton = findViewById(R.id.profButton3)
        profButton3.setOnClickListener {
            val intent = Intent(this, UserRoleSP::class.java)
            startActivity(intent)
        }
        //going to the CONTACT screen
        val contactButton3 : ImageButton = findViewById(R.id.contactButton3)
        contactButton3.setOnClickListener {
            val intent = Intent(this, ContactDetails::class.java)
            startActivity(intent)
        }
    }
}