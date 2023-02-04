package com.example.lovecalculator

import android.content.Context
import android.content.SharedPreferences

class Prefs(context: Context) {
    private var preferences :SharedPreferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE)

    fun saveState(){
        preferences.edit().putBoolean("isShown",true).apply()
    }
    fun isShown():Boolean{
        return preferences.getBoolean("isShown",false)
    }}