package com.example.a2_eduplayapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AdditionIdea : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_addition_idea)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //going back to the MATH topic selection screen
        val backToMatButton1 : ImageButton = findViewById(R.id.backToMatButton1)
        backToMatButton1.setOnClickListener {
            val intent = Intent(this, MathsSelection::class.java)
            startActivity(intent)
        }
        //going back to the HOME screen
        val backToSubButton8 : ImageButton = findViewById(R.id.backToSubButton8)
        backToSubButton8.setOnClickListener {
            val intent = Intent(this, SubjectSelection::class.java)
            startActivity(intent)
        }
        //going to the PROFILE screen
        val profButton8 : ImageButton = findViewById(R.id.profButton8)
        profButton8.setOnClickListener {
            val intent = Intent(this, UserRoleSP::class.java)
            startActivity(intent)
        }
        //going to the CONTACT screen
        val contactButton8 : ImageButton = findViewById(R.id.contactButton8)
        contactButton8.setOnClickListener {
            val intent = Intent(this, ContactDetails::class.java)
            startActivity(intent)
        }
    }
}