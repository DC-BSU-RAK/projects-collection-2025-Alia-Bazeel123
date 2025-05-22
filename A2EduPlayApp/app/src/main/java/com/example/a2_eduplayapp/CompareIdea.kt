package com.example.a2_eduplayapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CompareIdea : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_compare_idea)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //going back to the MATH topic selection screen
        val backToMatButton3 : ImageButton = findViewById(R.id.backToMatButton3)
        backToMatButton3.setOnClickListener {
            val intent = Intent(this, MathsSelection::class.java)
            startActivity(intent)
        }
        //going back to the HOME screen
        val backToSubButton10 : ImageButton = findViewById(R.id.backToSubButton10)
        backToSubButton10.setOnClickListener {
            val intent = Intent(this, SubjectSelection::class.java)
            startActivity(intent)
        }
        //going to the PROFILE screen
        val profButton10 : ImageButton = findViewById(R.id.profButton10)
        profButton10.setOnClickListener {
            val intent = Intent(this, UserRoleSP::class.java)
            startActivity(intent)
        }
        //going to the CONTACT screen
        val contactButton10 : ImageButton = findViewById(R.id.contactButton10)
        contactButton10.setOnClickListener {
            val intent = Intent(this, ContactDetails::class.java)
            startActivity(intent)
        }
    }
}