package com.example.lovecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.lovecalculator.databinding.FragmentBlankBinding
import com.example.lovecalculator.room.AppDataBase
import com.example.lovecalculator.viewmodel.LoveViewModel
import javax.inject.Inject


class BlankFragment() : Fragment() {
    lateinit var binding: FragmentBlankBinding
    private val viewModel: LoveViewModel by viewModels()

    @Inject
    lateinit var helper: Helper

    @Inject
    lateinit var dataBase: AppDataBase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlankBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnCalculate.setOnClickListener {

                with(viewModel) {
                    getLiveLoveModel(
                        etFirstName.text.toString(),
                        etSecondName.text.toString()
                    ).observe(
                        this@BlankFragment.viewLifecycleOwner,
                        Observer { loveData ->
                            binding.btnCalculate.text = loveData.percentage
                            helper.showToast(requireContext())
                            dataBase.loveDao().insert(loveData)
                        })
                }
            }
        }
    }
}



