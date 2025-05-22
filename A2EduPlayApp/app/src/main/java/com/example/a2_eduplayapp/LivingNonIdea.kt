package com.example.a2_eduplayapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LivingNonIdea : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_living_non_idea)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //going back to the SCIENCE topic selection screen
        val backToSciButton3 : ImageButton = findViewById(R.id.backToSciButton3)
        backToSciButton3.setOnClickListener {
            val intent = Intent(this, ScienceSelection::class.java)
            startActivity(intent)
        }
        //going back to the HOME screen
        val backToSubButton16 : ImageButton = findViewById(R.id.backToSubButton16)
        backToSubButton16.setOnClickListener {
            val intent = Intent(this, SubjectSelection::class.java)
            startActivity(intent)
        }
        //going to the PROFILE screen
        val profButton16 : ImageButton = findViewById(R.id.profButton16)
        profButton16.setOnClickListener {
            val intent = Intent(this, UserRoleSP::class.java)
            startActivity(intent)
        }
        //going to the CONTACT screen
        val contactButton16 : ImageButton = findViewById(R.id.contactButton16)
        contactButton16.setOnClickListener {
            val intent = Intent(this, ContactDetails::class.java)
            startActivity(intent)
        }
    }
}