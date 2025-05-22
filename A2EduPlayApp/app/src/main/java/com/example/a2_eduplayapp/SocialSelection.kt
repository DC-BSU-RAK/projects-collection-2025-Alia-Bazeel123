package com.example.a2_eduplayapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SocialSelection : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_social_selection)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //going to FAMILY TREE IDEAS screen
        val familyButton : Button = findViewById(R.id.familyButton)
        familyButton.setOnClickListener {
            val intent = Intent(this, FamilyTreeIdea::class.java)
            startActivity(intent)
        }
        //going to RESPONSIBILITIES IDEAS screen
        val responsibilityButton : Button = findViewById(R.id.responsibilityButton)
        responsibilityButton.setOnClickListener {
            val intent = Intent(this, ResponsibilitiesIdea::class.java)
            startActivity(intent)
        }
        //going to VARIOUS CULTURES IDEAS screen
        val culturesButton : Button = findViewById(R.id.culturesButton)
        culturesButton.setOnClickListener {
            val intent = Intent(this, VariousCulturesIdea::class.java)
            startActivity(intent)
        }
        //going back to the HOME screen
        val backToSubButton4 : ImageButton = findViewById(R.id.backToSubButton4)
        backToSubButton4.setOnClickListener {
            val intent = Intent(this, SubjectSelection::class.java)
            startActivity(intent)
        }
        //going to the PROFILE screen
        val profButton4 : ImageButton = findViewById(R.id.profButton4)
        profButton4.setOnClickListener {
            val intent = Intent(this, UserRoleSP::class.java)
            startActivity(intent)
        }
        //going to the CONTACT screen
        val contactButton4 : ImageButton = findViewById(R.id.contactButton4)
        contactButton4.setOnClickListener {
            val intent = Intent(this, ContactDetails::class.java)
            startActivity(intent)
        }
    }
}