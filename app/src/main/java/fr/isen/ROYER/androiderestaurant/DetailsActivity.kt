package fr.isen.ROYER.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import fr.isen.ROYER.androiderestaurant.databinding.DetailsBinding
import org.w3c.dom.Text
import kotlin.math.abs


class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: DetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailsBinding.inflate(layoutInflater)
        val item = intent.getSerializableExtra(ActivitySub.DETAILS_KEY) as Items
        val view = binding.root
        setContentView(view)
        val up = findViewById<FloatingActionButton>(R.id.addOne)
        val down = findViewById<FloatingActionButton>(R.id.deleteoneItem)
        val number=findViewById<TextView>(R.id.nbItem)
        val price=findViewById<Button>(R.id.PriceBouton)
        var cnt=0
        number.text= cnt.toString()
        binding.DetailsTitle.text = item.name_fr
        Log.d("images",item.toString())
        if(item.images.isNotEmpty()){
            binding.ImagesDetails.adapter= ImagesAdapter(this,item.images)}
        binding.DetailsInfo.text = item.ingredients.joinToString( ",", transform = { it.name_fr })
        binding.DetailsPrix.text = item.prices.joinToString { it.price+"€" }
        var tmp=binding.DetailsPrix.text.split("€")
        var tmpPrice=Integer.parseInt(tmp[0])
        price.text= "Total :"+(tmpPrice*cnt)+"€"
        //set on-click listener
        up.setOnClickListener {
            cnt++
            if(cnt>=0)
                number.text= cnt.toString()
            else
                number.text= abs(cnt).toString()
            price.text= "Total :"+(tmpPrice*cnt)+"€"
        }




        //set on-click listener
        down.setOnClickListener {

            if(cnt>0) {
                cnt--
                number.text = cnt.toString()
            }
            else
                number.text= 0.toString()
            price.text= "Total :"+(tmpPrice*cnt)+"€"
        }

    }
}