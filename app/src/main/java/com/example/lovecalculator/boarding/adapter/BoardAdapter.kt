package com.example.lovecalculator.boarding.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculator.Prefs
import com.example.lovecalculator.R
import com.example.lovecalculator.boarding.OnBoard
import com.example.lovecalculator.databinding.FragmentBoardingBinding

class BoardAdapter(var context: Context, private var navController: NavController, private var _binding: FragmentBoardingBinding)
    : RecyclerView.Adapter<BoardAdapter.ViewHolder>() {
    private val boards= arrayListOf<OnBoard>()
    init {
        boards.add(OnBoard(R.raw.love11,"Hello)"))
        boards.add(OnBoard(R.raw.love22,"Welcome!"))
        boards.add(OnBoard(R.raw.love33,"Let's get started!"))
        boards.add(OnBoard(R.raw.love11,"Calculate love!"))

    }
    inner class ViewHolder(
        private var binding: PagerBoardBinding
    )
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(Onboard: OnBoard) {
            binding.lotti.setAnimation(Onboard.image)
            binding.textTitle.text = Onboard.title
            _binding.btnSkip.setOnClickListener {
                val prefs= Prefs(context)
                prefs.saveState()
                navController.navigateUp()
            }
            binding.btnStart.setOnClickListener {

                val prefs=Prefs(context)

                prefs.saveState()

                navController.navigate(R.id.blankFragment)

            }
            if (boards.lastIndexOf(Onboard) == boards.lastIndex){
                binding.btnStart.visibility = View.VISIBLE
            } else{
                binding.btnStart.visibility = View.INVISIBLE
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardAdapter.ViewHolder {
        return ViewHolder(PagerBoardBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: BoardAdapter.ViewHolder, position: Int) {
        holder.bind(boards[position])
    }

    override fun getItemCount()=boards.size
}