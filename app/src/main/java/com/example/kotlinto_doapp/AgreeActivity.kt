package com.example.kotlinto_doapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast

class AgreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agree)

        var continueButton:Button = findViewById(R.id.continueButton)
        var agreeCheckBox: CheckBox = findViewById(R.id.agreeCheck)

        if(agreeCheckBox.isChecked){
            continueButton.isClickable = true
        }

        continueButton.setOnClickListener{
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}