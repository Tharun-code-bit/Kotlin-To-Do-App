package com.example.kotlinto_doapp


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var signin:Button =findViewById(R.id.sign_in_button_activity)
        var signup:Button =  findViewById(R.id.sign_up_button_activity3)

          signin.setOnClickListener{
              var intent = Intent(this,SigninActivity::class.java)
              startActivity(intent)
          }

        signup.setOnClickListener{
            var intent =Intent(this,SignupAcvtivity::class.java)
            startActivity(intent)
        }

        Firebase.auth.signOut()
    }
}
