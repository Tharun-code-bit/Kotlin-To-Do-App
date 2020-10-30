package com.example.kotlinto_doapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignupAcvtivity: AppCompatActivity() {

    // Initialize Firebase Authprivate lateinit var auth: FirebaseAuth
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signupbtn.setOnClickListener {
            val email: String = editTextTextEmailAddress.text.toString()
            val password: String = editTextTextPassword.text.toString()

            auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("SUCC", "createUserWithEmail:success")
                            val user = auth.currentUser
                            var intent = Intent(this, DashBoardActivity::class.java)

                            startActivity(intent)

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("WARN", "createUserWithEmail:failure", task.exception)
                            Toast.makeText(baseContext, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show()

                        }

                        // ...
                    }
        }
}
}