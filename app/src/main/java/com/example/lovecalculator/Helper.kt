package com.example.lovecalculator

import android.content.Context
import android.widget.Toast

class Helper {

    fun showToast(context: Context){
        Toast.makeText(context,"hello world",Toast.LENGTH_SHORT).show()
    }
}