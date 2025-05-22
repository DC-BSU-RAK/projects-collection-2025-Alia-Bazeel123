package com.example.a2_eduplayapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MathsSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_maths_selection)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //going to ADDITION IDEAS screen
        val addButton : ImageButton = findViewById(R.id.addButton)
        addButton.setOnClickListener {
            val intent = Intent(this, AdditionIdea::class.java)
            startActivity(intent)
        }
        //going to SUBTRACTION IDEAS screen
        val subButton : ImageButton = findViewById(R.id.subButton)
        subButton.setOnClickListener {
            val intent = Intent(this, SubtractionIdea::class.java)
            startActivity(intent)
        }
        //going to COMPARING NUMBERS IDEAS screen
        val comButton : ImageButton = findViewById(R.id.comButton)
        comButton.setOnClickListener {
            val intent = Intent(this, CompareIdea::class.java)
            startActivity(intent)
        }
        //going back to the HOME screen
        val backToSubButton2 : ImageButton = findViewById(R.id.backToSubButton2)
        backToSubButton2.setOnClickListener {
            val intent = Intent(this, SubjectSelection::class.java)
            startActivity(intent)
        }
        //going to the PROFILE screen
        val profButton2 : ImageButton = findViewById(R.id.profButton2)
        profButton2.setOnClickListener {
            val intent = Intent(this, UserRoleSP::class.java)
            startActivity(intent)
        }
        //going to the CONTACT screen
        val contactButton2 : ImageButton = findViewById(R.id.contactButton2)
        contactButton2.setOnClickListener {
            val intent = Intent(this, ContactDetails::class.java)
            startActivity(intent)
        }
    }
}