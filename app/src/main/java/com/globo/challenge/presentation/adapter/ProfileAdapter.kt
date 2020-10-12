package com.globo.challenge.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.globo.challenge.databinding.ItemProfileBinding

class ProfileAdapter(
    private var options: List<Int>
) : RecyclerView.Adapter<ProfileAdapter.Holder>(){

    lateinit var onItemClickedListener: (option: Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder (
            ItemProfileBinding.inflate(LayoutInflater.from(parent.context), parent,false),
            onItemClickedListener
        )
    }

    override fun getItemCount(): Int {
        return options.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(options[position])
    }

    class Holder(
        private val binding: ItemProfileBinding,
        private val onItemClickedListener: ((option: Int) -> Unit)):
        RecyclerView.ViewHolder(binding.root) {

        private var option: Int = 0

        fun bind(option: Int){
            this.option = option

            binding.optionTextView.text = itemView.context.getString(option)

            binding.root.setOnClickListener {
                onItemClickedListener.invoke(option)
            }
        }
    }
}