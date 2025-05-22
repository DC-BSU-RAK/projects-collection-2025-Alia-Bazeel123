package com.example.a2_eduplayapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class VariousCulturesIdea : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_various_cultures_idea)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //going back to the SOCIAL STUDIES topic selection screen
        val backToSocButton3 : ImageButton = findViewById(R.id.backToSocButton3)
        backToSocButton3.setOnClickListener {
            val intent = Intent(this, SocialSelection::class.java)
            startActivity(intent)
        }
        //going back to the HOME screen
        val backToSubButton13 : ImageButton = findViewById(R.id.backToSubButton13)
        backToSubButton13.setOnClickListener {
            val intent = Intent(this, SubjectSelection::class.java)
            startActivity(intent)
        }
        //going to the PROFILE screen
        val profButton13 : ImageButton = findViewById(R.id.profButton13)
        profButton13.setOnClickListener {
            val intent = Intent(this, UserRoleSP::class.java)
            startActivity(intent)
        }
        //going to the CONTACT screen
        val contactButton13 : ImageButton = findViewById(R.id.contactButton13)
        contactButton13.setOnClickListener {
            val intent = Intent(this, ContactDetails::class.java)
            startActivity(intent)
        }
    }
}