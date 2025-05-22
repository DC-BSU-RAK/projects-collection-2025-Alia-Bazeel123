package com.example.a2_eduplayapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NounIdea : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_noun_idea)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //going back to the ENGLISH topic selection screen
        val backToEngButton1 : ImageButton = findViewById(R.id.backToEngButton1)
        backToEngButton1.setOnClickListener {
            val intent = Intent(this, EnglishSelection::class.java)
            startActivity(intent)
        }
        //going back to the HOME screen
        val backToSubButton5 : ImageButton = findViewById(R.id.backToSubButton5)
        backToSubButton5.setOnClickListener {
            val intent = Intent(this, SubjectSelection::class.java)
            startActivity(intent)
        }
        //going to the PROFILE screen
        val profButton5 : ImageButton = findViewById(R.id.profButton5)
        profButton5.setOnClickListener {
            val intent = Intent(this, UserRoleSP::class.java)
            startActivity(intent)
        }
        //going to the CONTACT screen
        val contactButton5 : ImageButton = findViewById(R.id.contactButton5)
        contactButton5.setOnClickListener {
            val intent = Intent(this, ContactDetails::class.java)
            startActivity(intent)
        }
    }
}