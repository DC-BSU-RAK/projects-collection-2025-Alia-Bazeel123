package com.example.a2_eduplayapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FamilyTreeIdea : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_family_tree_idea)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //going back to the SOCIAL STUDIES topic selection screen
        val backToSocButton1 : ImageButton = findViewById(R.id.backToSocButton1)
        backToSocButton1.setOnClickListener {
            val intent = Intent(this, SocialSelection::class.java)
            startActivity(intent)
        }
        //going back to the HOME screen
        val backToSubButton11 : ImageButton = findViewById(R.id.backToSubButton11)
        backToSubButton11.setOnClickListener {
            val intent = Intent(this, SubjectSelection::class.java)
            startActivity(intent)
        }
        //going to the PROFILE screen
        val profButton11 : ImageButton = findViewById(R.id.profButton11)
        profButton11.setOnClickListener {
            val intent = Intent(this, UserRoleSP::class.java)
            startActivity(intent)
        }
        //going to the CONTACT screen
        val contactButton11 : ImageButton = findViewById(R.id.contactButton11)
        contactButton11.setOnClickListener {
            val intent = Intent(this, ContactDetails::class.java)
            startActivity(intent)
        }
    }
}