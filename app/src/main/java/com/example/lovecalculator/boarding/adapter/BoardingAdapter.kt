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
import kotlinx.coroutines.flow.internal.NoOpContinuation.context

class BoardingAdapter(val onItemClick: Context, var navController: NavController): RecyclerView.Adapter<BoardingAdapter.BoardingViewHolder>() {
    private var onBoardingList = arrayListOf(
        OnBoard("https://img.freepik.com/free-vector/virtual-relationships-and-online-dating-cartoon-illustration_1284-58109.jpg?w=1380&t=st=1672935980~exp=1672936580~hmac=b572390c88d0fbd6f9891dc0583a0db9a5b2cc030841ed31b5633abaad2c1a99", "Love calculator", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),
        OnBoard("https://img.freepik.com/premium-vector/a-man-gives-a-ring-to-a-girl_126980-114.jpg?w=1380", "Track progress", "Have a good time, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Viverra suspendisse potenti nullam ac tortor. "),
        OnBoard("https://img.freepik.com/free-vector/dating-couple-enjoying-romantic-dinner_74855-5233.jpg?w=1480&t=st=1672936007~exp=1672936607~hmac=c259aef39e773b2fd79abdd5b00389c8a63e15b3d95fc5558962df2d03cab0b7", "Cherishing love", "Tortor aliquam nulla facilisi cras fermentum odio eu. Risus in hendrerit gravida rutrum quisque non tellus."),
        OnBoard("https://img.freepik.com/free-vector/in-love-illustration-concept_114360-867.jpg?w=1380&t=st=1672936035~exp=1672936635~hmac=aa91ddb5c4498d8568042c5dd8d3a6acf443850e0760895180d311f08386c612", "Have a break up?", "Tortor aliquam nulla facilisi cras fermentum odio eu. Risus in hendrerit gravida rutrum quisque non tellus.")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardingViewHolder {
        return BoardingViewHolder(ItemViewPagerBinding.inflate(LayoutInflater.from(parent.context), parent , false))
    }

    override fun onBindViewHolder(holder: BoardingViewHolder, position: Int) {
        holder.bind(onBoardingList[position])
    }

    override fun getItemCount(): Int = onBoardingList.size
    inner class BoardingViewHolder(private val binding: ItemViewPagerBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(onBoard:OnBoard){
            binding.btnStart.isVisible = adapterPosition == onBoardingList.lastIndex
            binding.ivPicture.load(onBoard.image)
            binding.tvTitle.text = onBoard.title
            binding.tvDescription.text = onBoard.description

            binding.btnSkip.setOnClickListener {
                val prefs= Prefs(context)
                prefs.saveState()
                navController.navigateUp()
            }
            binding.btnStart.setOnClickListener {

                val prefs= Prefs(NoOpContinuation.context)

                prefs.saveState()

                navController.navigate(R.id.blankFragment)

            }
            if (onBoardingList.lastIndexOf(onBoard) == onBoardingList.lastIndex){
                binding.btnStart.visibility = View.VISIBLE
            } else{
                binding.btnStart.visibility = View.INVISIBLE
            }
        }
        }
    }
}