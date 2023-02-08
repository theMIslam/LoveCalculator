package com.example.lovecalculator.remote

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class LoveModel(
    @SerializedName("fname")
    var firstName: String,
    @SerializedName("sname")
    var secondName: String,
    var percentage: String,
    var result: String,
    @PrimaryKey(autoGenerate = true)
    val id:Int? = null
):java.io.Serializable