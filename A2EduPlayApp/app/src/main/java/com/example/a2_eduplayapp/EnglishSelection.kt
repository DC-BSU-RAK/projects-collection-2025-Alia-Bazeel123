package com.example.a2_eduplayapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EnglishSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_english_selection)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //going to NOUN IDEAS screen
        val nounButton : Button = findViewById(R.id.nounButton)
        nounButton.setOnClickListener {
            val intent = Intent(this, NounIdea::class.java)
            startActivity(intent)
        }
        //going to PRONOUN IDEAS screen
        val pronounButton : Button = findViewById(R.id.pronounButton)
        pronounButton.setOnClickListener {
            val intent = Intent(this, PronounIdea::class.java)
            startActivity(intent)
        }
        //going to VERB IDEAS screen
        val verbButton : Button = findViewById(R.id.verbButton)
        verbButton.setOnClickListener {
            val intent = Intent(this, VerbIdea::class.java)
            startActivity(intent)
        }
        //going back to the HOME screen
        val backToSubButton1 : ImageButton = findViewById(R.id.backToSubButton1)
        backToSubButton1.setOnClickListener {
            val intent = Intent(this, SubjectSelection::class.java)
            startActivity(intent)
        }
        //going to the PROFILE screen
        val profButton1 : ImageButton = findViewById(R.id.profButton1)
        profButton1.setOnClickListener {
            val intent = Intent(this, UserRoleSP::class.java)
            startActivity(intent)
        }
        //going to the CONTACT screen
        val contactButton1 : ImageButton = findViewById(R.id.contactButton1)
        contactButton1.setOnClickListener {
            val intent = Intent(this, ContactDetails::class.java)
            startActivity(intent)
        }
    }
}