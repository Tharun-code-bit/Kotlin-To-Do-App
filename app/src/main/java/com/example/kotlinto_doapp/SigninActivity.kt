package com.example.kotlinto_doapp



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_in.*

class SigninActivity : AppCompatActivity() {

// Initialize Firebase Authprivate lateinit var auth: FirebaseAuth
private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        auth = Firebase.auth

       sign_in2.setOnClickListener{

           val email:String=editTextTextEmailAddress4.text.toString()
           val password:String = password22.text.toString()
           if(email.trim() !="" && password.trim()!="") {
               auth.signInWithEmailAndPassword(email, password)
                       .addOnCompleteListener(this) { task ->
                           if (task.isSuccessful) {
                               val user = auth.currentUser

                               if (user != null) {
                                   Toast.makeText(applicationContext,user.uid, Toast.LENGTH_SHORT).show()
                                   var intent = Intent(this,DashBoardActivity::class.java)

                                    startActivity(intent)
                                   }

                           } else {
                               Toast.makeText(baseContext, "Authentication failed.",
                                       Toast.LENGTH_SHORT).show()

                           }
                       }
           }
           else{
               Toast.makeText(applicationContext,"Fill The Form",Toast.LENGTH_SHORT).show()
           }
       }
    }
}
