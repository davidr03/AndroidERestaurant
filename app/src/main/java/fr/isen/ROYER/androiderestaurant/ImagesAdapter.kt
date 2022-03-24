package fr.isen.ROYER.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter


class ImagesAdapter (activity : AppCompatActivity, val images : List<String>): FragmentStateAdapter(activity){
    override fun getItemCount(): Int = images.size

    override fun createFragment(position: Int): Fragment {
        return ImageFragment(images[position].ifEmpty { null })
    }
}

