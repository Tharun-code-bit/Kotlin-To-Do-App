package com.example.kotlinto_doapp

import android.content.Context
import android.content.SharedPreferences


class PrefManager(private var context: Context) {

    var pref: SharedPreferences? =null
    var editor:SharedPreferences.Editor?=null
    var _context:Context? =null

    companion object {
        val PREF_NAME:String="welcome"
        val IS_FIRST_TIME_LAUNCH ="IsFirstTimeLaunch"
        var PRIVATE_MODE:Int =0
    }


  init{

      _context=context
      pref= _context!!.getSharedPreferences(PREF_NAME,PRIVATE_MODE)
      editor = pref!!.edit()

  }

    fun setFirstTimeLaunch(isfirsttime:Boolean){
        editor!!.putBoolean(IS_FIRST_TIME_LAUNCH,isfirsttime)
        editor!!.commit()
    }

    fun isFirstTimeLaunch():Boolean{
        return pref!!.getBoolean(IS_FIRST_TIME_LAUNCH,true)
    }


}