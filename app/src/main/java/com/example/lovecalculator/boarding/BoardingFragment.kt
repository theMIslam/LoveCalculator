package com.example.lovecalculator.boarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.boarding.adapter.BoardingAdapter
import com.example.lovecalculator.databinding.FragmentBoardingBinding

class BoardFragment : Fragment() {
    private lateinit var binding: FragmentBoardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter=BoardingAdapter(requireContext(),findNavController())
        binding.viewPager.adapter=adapter
        binding.dotsIndicator.attachTo(binding.viewPager)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,object:
            OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }

        })

    }
}
