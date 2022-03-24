package fr.isen.ROYER.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import fr.isen.ROYER.androiderestaurant.databinding.DetailsBinding


class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: DetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailsBinding.inflate(layoutInflater)
        val item = intent.getSerializableExtra(ActivitySub.DETAILS_KEY) as Items
        val view = binding.root
        setContentView(view)
        val intent = intent


        binding.DetailsTitle.text = item.name_fr
        Log.d("images",item.toString())
        if(item.images.isNotEmpty()){
            binding.ImagesDetails.adapter= ImagesAdapter(this,item.images)}
        binding.DetailsInfo.text = item.ingredients.joinToString( ",", transform = { it.name_fr })
        binding.DetailsPrix.text = item.prices.joinToString { it.price+"€" }

    }
}