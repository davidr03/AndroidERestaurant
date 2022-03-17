package fr.isen.ROYER.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.Gson
import fr.isen.ROYER.androiderestaurant.databinding.ActivitySubBinding
import fr.isen.ROYER.androiderestaurant.databinding.DetailsBinding
import org.json.JSONObject

class ActivitySub : AppCompatActivity() {
    private lateinit var binding : ActivitySubBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySubBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        val texttitle= intent.getStringExtra("12345")?:""
        binding.Title.text=texttitle
        title = intent.getStringExtra("12345")

        binding.listeFood.layoutManager=LinearLayoutManager(this)
        binding.listeFood.adapter=FoodAdapter(arrayListOf(),{})
        var monRecycler: RecyclerView = findViewById(R.id.listeFood)

        loadItemsHttp(texttitle)
        val back = findViewById<FloatingActionButton>(R.id.back)

        //set on-click listener
        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }

    }


    private fun loadItemsHttp(category : String) {
        val url = "http://test.api.catering.bluecodegames.com/menu"
        val obj = JSONObject()
        obj.put("id_shop", "1")
        val queue = Volley.newRequestQueue(this)

        val jsonObjectRequest = JsonObjectRequest(Request.Method.POST, url, obj,
            { response ->

                Log.d("Response", "$response")
                Log.d("MenuActivity", "Api call succes")
                val menu = Gson().fromJson(response.toString(), Data::class.java)

                val items = menu.data.firstOrNull{ it.name_fr == category }?.items ?: arrayListOf()
                val adapter = FoodAdapter(items) {
                    val intent = Intent(this, DetailsActivity::class.java)

                    intent.putExtra(DETAILS_KEY, it)
                    startActivity(intent)
                }
                binding.listeFood.adapter = adapter

            },
            { error ->
                Log.d("MenuActivity", "Api call failed")
            }
        )
        queue.add(jsonObjectRequest)
    }

    companion object {
        const val DETAILS_KEY = "details"
    }
}