package fr.isen.ROYER.androiderestaurant

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

data class Food(val id: Long, val nom: String,val prix:String)


class FoodAdapter(val items:List<Items>,val mListener:(Items)->Unit):RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cate_cell, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i("XXX", "onBindViewHolder")
        val menu=items[position]
        holder.dishName.text = menu.name_fr
        holder.prix.text=menu.prices[0].price+"€"
        Picasso.get().load(menu.images[0].ifEmpty { null }).into(holder.imageDish)
        holder.itemView.setOnClickListener {

            mListener(menu)
        }
    }



    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dishName : TextView = view.findViewById(R.id.categoryTitle)
        val prix :TextView=view.findViewById(R.id.Prix)
        val imageDish : ImageView=view.findViewById(R.id.imageDish)
    }
}

