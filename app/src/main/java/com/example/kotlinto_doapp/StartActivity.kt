package com.example.kotlinto_doapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

      val pref = PrefManager(this)

        if(!pref.isFirstTimeLaunch()){
            val i =Intent(this@StartActivity,HomePage::class.java)
            startActivity(i)
            finish()
        }

        setContentView(R.layout.activity_start)

        pref.setFirstTimeLaunch(false)
        var startButton:Button = findViewById(R.id.startButton)

        startButton.setOnClickListener{
            var intent = Intent(this,AgreeActivity::class.java)
            startActivity(intent)
        }
    }
}