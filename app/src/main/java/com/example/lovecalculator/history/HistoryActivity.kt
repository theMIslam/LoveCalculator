package com.example.lovecalculator.history

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.lovecalculator.databinding.ActivityHistoryBinding
import com.example.lovecalculator.room.LoveDao
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class HistoryActivity : AppCompatActivity() {
    @Inject
    lateinit var dataBase: LoveDao

    lateinit var binding: ActivityHistoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataBase.getAllAtoZ().observe(this, Observer {listData->
            var data=""
            listData.forEach {loveModel->
                data+="${loveModel.firstName} \n${loveModel.secondName} \n${loveModel.percentage} \n${loveModel.result} \n"
            }
            binding.historyTv.text=data
        })

    }
}