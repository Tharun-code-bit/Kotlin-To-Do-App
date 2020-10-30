package com.example.kotlinto_doapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val handler = Handler()
        handler.postDelayed({
            val i = Intent(this@HomePage,MainActivity::class.java)
            startActivity(i)
            finish()
        }, 3000)


    }
}