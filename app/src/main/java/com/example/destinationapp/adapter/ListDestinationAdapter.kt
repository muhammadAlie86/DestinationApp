package com.example.destinationapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.destinationapp.databinding.ItemListDestinationBinding
import com.example.destinationapp.model.Destination
import com.example.destinationapp.utils.DataCallback

class ListDestinationAdapter (private  val dataCallback : DataCallback) : RecyclerView.Adapter<ListDestinationAdapter.ListViewHolder>() {

    private val listDestination = ArrayList<Destination>()

    fun setDestination(destination: List<Destination>){
        this.listDestination.addAll(destination)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemListDestinationBinding = ItemListDestinationBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder(itemListDestinationBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val destination = listDestination[position]
        holder.bind(destination)
    }

    override fun getItemCount(): Int = listDestination.size

    inner class ListViewHolder (private val binding: ItemListDestinationBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(destination: Destination){
            with(binding){
                tvName.text = destination.name
                tvLocation.text = destination.location
                ratingBar.rating = destination.rate
                tvDescription.text = destination.description
                imgPoster.setImageResource(destination.image)

                imgPoster.setOnClickListener { dataCallback.setData(destination) }
            }
        }

    }
}