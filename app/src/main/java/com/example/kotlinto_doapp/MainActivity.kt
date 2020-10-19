package com.example.kotlinto_doapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.sign_in_button_activity)
        button.setOnClickListener{
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }

        val button2 = findViewById<Button>(R.id.sign_in_button_activity2)
        button2.setOnClickListener{
            val intent = Intent(this, DashBoard::class.java)
            startActivity(intent)
        }

        val button3 = findViewById<Button>(R.id.sign_in_button_activity3)
        button3.setOnClickListener{
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }


}
