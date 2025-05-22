package com.example.a2_coffifyapp

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val moodSpinner: Spinner = findViewById(R.id.moodSpinner)
        val timeSpinner: Spinner = findViewById(R.id.timeSpinner)
        //create an array of moods and timeframe using arrayOf
        val mood = arrayOf("Select your Mood", "Sleepy", "Chill", "Stressed", "Happy", "Focused")
        val time = arrayOf("Select your Brew Time", "Morning", "Evening", "Study Time", "Afternoon", "Night Owl")

        //assigning above array to the spinner using the following instruction
        moodSpinner.adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_dropdown_item, mood)
        timeSpinner.adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_dropdown_item, time)

        //mapping/assigning values for each selection
        val mapped_coffee = mapOf(
            "Select your Mood" to mapOf(
                "Select your Brew Time" to "Selection invalid!",
                "Morning" to "Invalid Mood",
                "Evening" to "Invalid Mood",
                "Study Time" to "Invalid Mood",
                "Afternoon" to "Invalid Mood",
                "Night Owl" to "Invalid Mood"
            ),
            "Sleepy" to mapOf(
                "Select your Brew Time" to "Invalid Brew Time",
                "Morning" to "Double Espresso",
                "Evening" to "Light Roast Drip Coffee",
                "Study Time" to "Mocha Latte",
                "Afternoon" to "Café Americano",
                "Night Owl" to "Espresso Macchiato"
            ),
            "Chill" to mapOf(
                "Select your Brew Time" to "Invalid Brew Time",
                "Morning" to "Café au Lait",
                "Evening" to "Iced Vanilla Latte",
                "Study Time" to "Matcha Latte",
                "Afternoon" to "Iced Flat White",
                "Night Owl" to "Decaf Cappuccino"
            ),
            "Stressed" to mapOf(
                "Select your Brew Time" to "Invalid Brew Time",
                "Morning" to "Cinnamon Latte",
                "Evening" to "Hazelnut Latte",
                "Study Time" to "Flat White with oat milk",
                "Afternoon" to "Cortado",
                "Night Owl" to "Strong Brewed Coffee"
            ),
            "Happy" to mapOf(
                "Select your Brew Time" to "Invalid Brew Time",
                "Morning" to "Cappuccino with cinnamon",
                "Evening" to "Irish Cream Cold Brew",
                "Study Time" to "Vanilla Iced Coffee",
                "Afternoon" to "Caramel Macchiato",
                "Night Owl" to "Affogato, i.e., espresso and ice cream"
            ),
            "Focused" to mapOf(
                "Select your Brew Time" to "Invalid Brew Time",
                "Morning" to "Bulletproof Coffee with butter",
                "Evening" to "Long Black",
                "Study Time" to "Black Coffee, No Sugar",
                "Afternoon" to "Nitro Cold Brew",
                "Night Owl" to "Cold Brew"
            )
        )

        //providing image to each coffee suggestion
        val coffeeImages = mapOf(
            "Double Espresso" to R.drawable.coffee2_double_espresso,
            "Café Americano" to R.drawable.coffee3_cafe_americano,
            "Light Roast Drip Coffee" to R.drawable.coffee4_light_roast_drip_coffee,
            "Mocha Latte" to R.drawable.coffee5_mocha_latte,
            "Espresso Macchiato" to R.drawable.coffee6_espresso_macchiato,
            "Café au Lait" to R.drawable.coffee7_afe_au_lait,
            "Iced Flat White" to R.drawable.coffee8_iced_flat_white,
            "Iced Vanilla Latte" to R.drawable.coffee9_iced_vanilla_latte,
            "Matcha Latte" to R.drawable.coffee10_matcha_latte,
            "Decaf Cappuccino" to R.drawable.coffee11_decaf_cappuccino,
            "Cinnamon Latte" to R.drawable.coffee12_cinnamon_latte,
            "Cortado" to R.drawable.coffee13_cortado,
            "Hazelnut Latte" to R.drawable.coffee14_hazelnut_latte,
            "Flat White with oat milk" to R.drawable.coffee15_flat_white_with_oat_milk,
            "Strong Brewed Coffee" to R.drawable.coffee16_strong_brewed_coffee,
            "Cappuccino with cinnamon" to R.drawable.coffee17_cappuccino_with_cinnamon,
            "Caramel Macchiato" to R.drawable.coffee18_caramel_macchiato,
            "Irish Cream Cold Brew" to R.drawable.coffee19_irish_cream_cold_brew,
            "Vanilla Iced Coffee" to R.drawable.coffee20_vanilla_iced_coffee,
            "Affogato, i.e., espresso and ice cream" to R.drawable.coffee21_affogato,
            "Bulletproof Coffee with butter" to R.drawable.coffee22_bulletproof_coffee,
            "Nitro Cold Brew" to R.drawable.coffee23_nitro_cold_brew,
            "Long Black" to R.drawable.coffee24_long_black,
            "Black Coffee, No Sugar" to R.drawable.coffee25_black_coffee,
            "Cold Brew" to R.drawable.coffee26_cold_brew
        )


        //SETTING INSTRUCTIONS (POP-UP)
        val instructionButton: ImageButton = findViewById(R.id.instructionButton)
        instructionButton.setOnClickListener {
            val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val popupView = inflater.inflate(R.layout.activity_pop_up, null)
            val width = 1025
            val height = 1875
            val instructWindow = PopupWindow(popupView, width, height, true)
            instructWindow.showAtLocation(popupView, Gravity.BOTTOM, 0, 75)
            val instructCloseButton: ImageButton = popupView.findViewById(R.id.instructCloseButton)
            instructCloseButton.setOnClickListener {
                instructWindow.dismiss()
            }
        }


        //SETTING COFFEE SUGGESTION (POP-UP)
        val suggestButton: Button = findViewById(R.id.suggestButton)

        suggestButton.setOnClickListener {
            val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val popupView = inflater.inflate(R.layout.activity_suggestion_pop_up, null)
            val width = 1050
            val height = 950
            val suggestWindow = PopupWindow(popupView, width, height, true)
            suggestWindow.showAtLocation(popupView, Gravity.BOTTOM, 3, 75)

            //this function is executed on button click
            //retrieving values from spinners
            val selectedMood = moodSpinner.selectedItem.toString()
            val selectedTime = timeSpinner.selectedItem.toString()

            //getting coffee suggestion based on the selected mood and brew time
            // if not found it will return Invalid selection text
            val result_coffee = mapped_coffee[selectedMood]?.get(selectedTime) ?: "Invalid selection! Select your preferred choice."
            val coffeeSuggestion: TextView = popupView.findViewById(R.id.coffeeSuggestion)
            //Following instruction is used to display text on output screen
            coffeeSuggestion.text = result_coffee

            val coffeeImage: ImageView = popupView.findViewById(R.id.coffeeImage)
            val imageRes = coffeeImages[result_coffee] ?: R.drawable.coffee1
            coffeeImage.setImageResource(imageRes)

            val suggestCloseButton: ImageButton = popupView.findViewById(R.id.suggestCloseButton)
            suggestCloseButton.setOnClickListener {
                suggestWindow.dismiss()
            }
        }
    }
}