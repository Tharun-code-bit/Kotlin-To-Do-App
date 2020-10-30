
package com.example.kotlinto_doapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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

         var arrayList = ArrayList<String>()



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


       //Read From CLOUD
       myref.child(uid).child("task").addListenerForSingleValueEvent(object: ValueEventListener
             {

             override fun onDataChange(dataSnapshot: DataSnapshot) {
                 for( i:DataSnapshot in dataSnapshot.children){
                     arrayList.add(i.value.toString())
                 }


                 val vowels_array: Array<String> = arrayList.toTypedArray()
                 val arrayAdapter = ArrayAdapter<String>(applicationContext,R.layout.mylist,vowels_array)
                 listview.adapter = arrayAdapter

             //   listshow(arrayList,removebtn,arraylistsize)
             }
            override   fun onCancelled(error: DatabaseError) {
                 // Failed to read value
                 Log.w("f", "Failed to read value.", error.toException());
             }
         })

           // WRITING TO CLOUD
          addtaskbtn.setOnClickListener {
              val task:String = taskuserinput.text.toString()
               arrayList.add(task)
             myref.child(uid).child("email").setValue(useremail)
             myref.child(uid).child("task").setValue(arrayList)

              val i = Intent(this@DashBoardActivity, DashBoardActivity::class.java)
              finish()
              overridePendingTransition(0, 0)
              startActivity(i)
              overridePendingTransition(0, 0)
         }

         //LIST Click Events
         listview.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
             val selectedItem = adapterView.getItemAtPosition(position) as String
             val itemIdAtPos = adapterView.getItemIdAtPosition(position)

             Toast.makeText(applicationContext,"click item $selectedItem its position $itemIdAtPos",Toast.LENGTH_SHORT).show()
         }

         listview.onItemLongClickListener = AdapterView.OnItemLongClickListener { adapterView, view, position, id->
             Toast.makeText(applicationContext, "Long clicked", Toast.LENGTH_SHORT).show()

             val alertbuilder=AlertDialog.Builder(this)

             alertbuilder.setTitle("Remove Task")
             //set message for alert dialog
             alertbuilder.setMessage("Do you want to remove this task?")
             alertbuilder.setIcon(android.R.drawable.ic_dialog_alert)

             //performing positive action
             alertbuilder.setPositiveButton("Yes"){dialogInterface, which ->
                 Toast.makeText(applicationContext,"clicked yes",Toast.LENGTH_LONG).show()
                 arrayList.removeAt(position)
                 myref.child(uid).child("email").setValue(useremail)
                 myref.child(uid).child("task").setValue(arrayList)

                 //Refresh the page
                 val i = Intent(this@DashBoardActivity, DashBoardActivity::class.java)
                 finish()
                 overridePendingTransition(0, 0)
                 startActivity(i)
                 overridePendingTransition(0, 0)
             }

             //performing negative action
             alertbuilder.setNegativeButton("No"){dialogInterface, which ->
                 Toast.makeText(applicationContext,"clicked No",Toast.LENGTH_LONG).show()
             }
             val alertDialog: AlertDialog = alertbuilder.create()
             // Set other dialog properties
             alertDialog.setCancelable(false)
             alertDialog.show()
             true
         }




     }









}



