package com.example.lovecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.databinding.FragmentBlankBinding
import com.example.lovecalculator.viewmodel.LoveViewModel


class BlankFragment() : Fragment() {
    lateinit var binding: FragmentBlankBinding
    private val viewModel : LoveViewModel by viewModels()

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
                viewModel.getLiveLove(etFirstName.text.toString(),etSecondName.text.toString()).observe(
                    viewLifecycleOwner, Observer {
                        findNavController().navigate(R.id.fistFragment, bundleOf("key" to (it?.percentage
                                )))
                    }
                )
            }
        }
    }

}
