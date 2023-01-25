package com.example.lovecalculator

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
    @GET("getPercentage")
    fun calculateLove(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key: String = "5a0017116fmsh75c37c5a76e056ap16e3a0jsnf7e1da28344b",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
    ):Call<LoveModel>
}