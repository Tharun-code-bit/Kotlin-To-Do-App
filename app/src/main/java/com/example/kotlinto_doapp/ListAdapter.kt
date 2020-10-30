package com.example.kotlinto_doapp

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView


class ListAdapter(private val context: Activity, private var tasks: Array<String>, private var button:Array<String>):ArrayAdapter<String>(context,R.layout.mylist,button) {

    override  fun getView( position:Int, view: View?,parent:ViewGroup): View {
        val inflator = context.layoutInflater
        val rowview = inflator.inflate(R.layout.mylist,null,true)


        val taskstext =rowview.findViewById(R.id.task) as TextView


        taskstext.setText(tasks[position])





        return rowview
    }


}

