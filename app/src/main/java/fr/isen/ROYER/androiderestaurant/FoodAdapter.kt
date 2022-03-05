package fr.isen.ROYER.androiderestaurant

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Food(val id: Long, val nom: String)


class FoodAdapter(val FoodAfficher: Array<Food>, val listener: (Food) -> Unit) :
    RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cate_cell, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = FoodAfficher.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i("XXX", "onBindViewHolder")
        holder.dishName.text = FoodAfficher[position].nom
        holder.itemView.setOnClickListener { listener(FoodAfficher[position]) }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dishName : TextView = view.findViewById(R.id.categoryTitle)
    }
}

