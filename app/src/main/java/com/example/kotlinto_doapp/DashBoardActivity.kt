package com.example.kotlinto_doapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_dash_board.*


class DashBoardActivity:AppCompatActivity() {

     override fun onCreate(savedInstanceState:Bundle?){
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_dash_board)

         val  database =FirebaseDatabase.getInstance()
         val  myref  =database.getReference("list")

         val arrayList = ArrayList<String>()
         var uid=""
         var useremail=""
         val user = FirebaseAuth.getInstance().currentUser
         if (user != null) {
             // Name, email address, and profile photo Url

             val email = user.email
             val userid = user.uid
                    uid=userid
             useremail= email.toString()
             tvusername.setText(useremail)
         }


        myref.child(uid).child("task").addListenerForSingleValueEvent(object: ValueEventListener
             {

             override fun onDataChange(dataSnapshot: DataSnapshot) {

                  // var usertask: UserTask? =dataSnapshot.getValue(UserTask::class.java)
                 for( i:DataSnapshot in dataSnapshot.children){
                     arrayList.add(i.toString())
                 }
                 Log.w("f", "Failed to read value.")

             }

            override   fun onCancelled(error: DatabaseError) {
                 // Failed to read value
                 Log.w("f", "Failed to read value.", error.toException());
             }
         })

           // WRITING TO CLOUD
          addtaskbtn.setOnClickListener {
              val task:String =     taskuserinput.text.toString()
               arrayList.add(task)
             myref.child(uid).child("email").setValue(useremail)
             myref.child(uid).child("task").setValue(arrayList)

         }

     }



}


