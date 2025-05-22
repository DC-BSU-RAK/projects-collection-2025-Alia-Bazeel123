package com.example.a2_eduplayapp

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageButton
import android.widget.PopupWindow
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SubjectSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_subject_selection)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //SETTING HAMBURGER ICON (POP-UP VIEW)
        val optionButton: ImageButton = findViewById(R.id.optionButton)
        optionButton.setOnClickListener {
            val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val popupView = inflater.inflate(R.layout.activity_home_options, null)
            val width = 450
            val height = 1500
            val optionsWindow = PopupWindow(popupView, width, height, true)
            optionsWindow.showAtLocation(popupView, Gravity.BOTTOM, -1500, 850)
            //Closing the hamburger pop-up
            val optionCloseButton: ImageButton = popupView.findViewById(R.id.optionCloseButton)
            optionCloseButton.setOnClickListener {
                optionsWindow.dismiss()
            }
            //opening the how to use the app screen
            val useButton : Button = popupView.findViewById(R.id.useButton)
            useButton.setOnClickListener{
                val intent = Intent(this,AppUsage::class.java)
                startActivity(intent)
            }
            //opening the app info screen
            val infoButton : Button = popupView.findViewById(R.id.infoButton)
            infoButton.setOnClickListener {
                val intent = Intent(this, AppInfo::class.java)
                startActivity(intent)
            }
            //opening the profile screen
            val profButton : Button = popupView.findViewById(R.id.profButton)
            profButton.setOnClickListener{
                val intent = Intent(this,UserRoleSP::class.java)
                startActivity(intent)
            }
            //opening the contact screen
            val contactButton : Button = popupView.findViewById(R.id.contactButton)
            contactButton.setOnClickListener{
                val intent = Intent(this,ContactDetails::class.java)
                startActivity(intent)
            }
        }
        //going to ENGLISH topic selection screen
        val engButton : ImageButton = findViewById(R.id.engButton)
        engButton.setOnClickListener {
            val intent = Intent(this, EnglishSelection::class.java)
            startActivity(intent)
        }
        //going to MATHS topic selection screen
        val matButton : ImageButton = findViewById(R.id.matButton)
        matButton.setOnClickListener {
            val intent = Intent(this, MathsSelection::class.java)
            startActivity(intent)
        }
        //going to SCIENCE topic selection screen
        val sciButton : ImageButton = findViewById(R.id.sciButton)
        sciButton.setOnClickListener {
            val intent = Intent(this, ScienceSelection::class.java)
            startActivity(intent)
        }
        //going to SOCIAL topic selection screen
        val socButton : ImageButton = findViewById(R.id.socButton)
        socButton.setOnClickListener {
            val intent = Intent(this, SocialSelection::class.java)
            startActivity(intent)
        }
    }
}