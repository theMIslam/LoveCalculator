package com.example.lovecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lovecalculator.databinding.FragmentBlankBinding
import com.example.lovecalculator.databinding.FragmentFistBinding

class FistFragment : Fragment() {
    lateinit var binding: FragmentFistBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFistBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val result:LoveModel = arguments?.getSerializable("key") as LoveModel
        binding.tvFirstName.text = result.firstName
        binding.tvSecondName.text = result.secondName
        binding.tvPercentage.text = result.percentage
        binding.tvResult.text = result.result
    }
}