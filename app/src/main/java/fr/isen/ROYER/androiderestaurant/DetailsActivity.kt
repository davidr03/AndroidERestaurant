package fr.isen.ROYER.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import fr.isen.ROYER.androiderestaurant.databinding.DetailsBinding


class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: DetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val intent = intent

        val item = intent.getSerializableExtra(ActivitySub.DETAILS_KEY) as Items
        binding.DetailsTitle.text = item.name_fr



        binding.DetailsInfo.text = item.ingredients.joinToString(", ", transform = { it.name_fr })

        Log.i("image", item.images.toString())

    }
}