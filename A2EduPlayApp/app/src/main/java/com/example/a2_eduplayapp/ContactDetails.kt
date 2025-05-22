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

class ContactDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contact_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //going back to the home screen
        val contactBackButton : ImageButton = findViewById(R.id.contactBackButton)
        contactBackButton.setOnClickListener {
            val intent = Intent(this, SubjectSelection::class.java)
            startActivity(intent)
        }
        //SETTING FEEDBACK (POP-UP VIEW)
        val feedbackButton: Button = findViewById(R.id.feedbackButton)
        feedbackButton.setOnClickListener {
            val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val popupView = inflater.inflate(R.layout.activity_feed_back_pop_up, null)
            val width = 1000
            val height = 1900
            val feedbackWindow = PopupWindow(popupView, width, height, true)
            feedbackWindow.showAtLocation(popupView, Gravity.BOTTOM, 0, 250)
            //Closing the feedback pop-up
            val feedbackSubmitButton: Button = popupView.findViewById(R.id.feedbackSubmitButton)
            feedbackSubmitButton.setOnClickListener {
                feedbackWindow.dismiss()
            }
        }
    }
}