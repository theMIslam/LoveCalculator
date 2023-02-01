package com.example.lovecalculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.databinding.FragmentBlankBinding
import com.example.lovecalculator.remote.LoveModel
import com.example.lovecalculator.remote.RetrofitService
import com.example.lovecalculator.viewmodel.LoveViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BlankFragment() : Fragment() {
    lateinit var binding: FragmentBlankBinding
    private lateinit var viewModel: LoveViewModel
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
                RetrofitService().api.calculateLove(
                    etFirstName.text.toString(),
                    etSecondName.text.toString()
                )
                    .enqueue(object : Callback<LoveModel> {
                        override fun onResponse(
                            call: Call<LoveModel>,
                            response: Response<LoveModel>
                        ) {
                            if (response.isSuccessful) {

                            }
                        }

                        override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                            Log.e("ololo", "OnFailure ${t.message}")
                        }

                    })
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
