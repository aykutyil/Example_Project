package com.example.exampleproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleproject.R
import com.example.exampleproject.databinding.RocketItemLayoutBinding
import com.example.exampleproject.model.RocketsItem
import kotlinx.android.synthetic.main.rocket_item_layout.view.*

class RocketsAdapter : RecyclerView.Adapter<RocketsAdapter.RocketViewHolder>() {

    inner class RocketViewHolder(var view: RocketItemLayoutBinding) : RecyclerView.ViewHolder(view.root)

    private val differCallBack = object : DiffUtil.ItemCallback<RocketsItem>() {
        override fun areItemsTheSame(oldItem: RocketsItem, newItem: RocketsItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: RocketsItem, newItem: RocketsItem): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val mView = DataBindingUtil.inflate<RocketItemLayoutBinding>(
            inflater,
            R.layout.rocket_item_layout,
            parent,
            false
        )
        return RocketViewHolder(mView)
    }

    override fun onBindViewHolder(holder: RocketViewHolder, position: Int) {
        val currentRocket = differ.currentList[position]
        holder.view.rocketsItem = currentRocket
        holder.itemView.setOnClickListener {
            onClickListener?.let {
                it(currentRocket)
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onClickListener:((RocketsItem)-> Unit)? = null

    fun setOnItemClickListener(listener : (RocketsItem)-> Unit){
        onClickListener = listener
    }
}