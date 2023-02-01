package com.example.lovecalculator.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator.remote.LoveModel
import com.example.lovecalculator.repository.Repository

class LoveViewModel() : ViewModel() {

    fun getLiveLove(firstName: String, secondName: String): LiveData<LoveModel> {
        return Repository().getLove(firstName, secondName)
    }
}