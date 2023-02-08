package com.example.lovecalculator.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lovecalculator.remote.LoveModel

@Dao
interface LoveDao {

    @Insert
    fun insert(loveModel: LoveModel)

    @Query("SELECT * FROM 'LOVE-HISTORY'")
    fun getAll():LiveData<List<LoveModel>>

    @Query("SELECT * FROM 'LOVE-HISTORY' ORDER BY firstName ASC")
    fun getAllAtoZ():LiveData<List<LoveModel>>

}