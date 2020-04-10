package com.example.dogs.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dogs.R
import com.example.dogs.model.DogBreed
import kotlinx.android.synthetic.main.item_dog.view.*

// Make sure of naming and model
class DogsListAdapter(val dogsList: ArrayList<DogBreed>) : RecyclerView.Adapter<DogsListAdapter.DogViewHolder>() {

    // We will need this to update the information on the screen because we will load data from backend
    fun updateDogList(newDogsList: List<DogBreed>) {
        dogsList.clear()
        dogsList.addAll(newDogsList)
        // This is to reset everything and make the system re-create the list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        // Here you need to pass your layout
        val view: View = inflater.inflate(R.layout.item_dog, parent, false)
        return DogViewHolder(view)
    }

    override fun getItemCount() = dogsList.size

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        /* Here the holder followed by the view which comes from the DogsViewHolder
        *  then the view is followed by the name which is the field is (id) in layout file (item_dog)
        * then the name is followed by text which is comes from getText and setText mehthods */
        holder.view.name.text = dogsList[position].dogBreed
        holder.view.lifespan.text = dogsList[position].lifeSpan
    }

    // This is class with its constructor and with extend
    //class DogViewHolder(var view: View, itemView: View) : RecyclerView.ViewHolder(itemView) {
    class DogViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
    }

}