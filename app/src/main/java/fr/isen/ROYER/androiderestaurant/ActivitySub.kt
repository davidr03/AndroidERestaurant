package fr.isen.ROYER.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ActivitySub : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val texttitle = findViewById<TextView>(R.id.Title)
        texttitle.text=intent.getStringExtra("12345")
        title = intent.getStringExtra("12345")

        val  food = CreerMesLigne(texttitle)
        var monRecycler: RecyclerView = findViewById(R.id.listeFood)
        monRecycler.layoutManager = LinearLayoutManager(this)
        monRecycler.adapter = FoodAdapter(food.toTypedArray())
        {
            Toast.makeText(this, "Vous avez sélectionné ${it.nom}", Toast.LENGTH_SHORT).show()
        }

        val back = findViewById<FloatingActionButton>(R.id.back)

        //set on-click listener
        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }
    }



    private fun CreerMesLigne(textTitle: TextView) :ArrayList<Food> {
        val food = ArrayList<Food>()
        if(textTitle.text=="Entrée") {
            food.add(Food(1, "entree 1","€"))
            food.add(Food(2, "entree 2","€"))
            food.add(Food(3, "entree 3","€"))
            food.add(Food(4, "entree 4","€"))
            food.add(Food(5, "entree 5","€"))
        }
        else if(textTitle.text=="Plats") {
            food.add(Food(1, "plat 1","€"))
            food.add(Food(2, "plat 2","€"))
            food.add(Food(3, "plat 3","€"))
            food.add(Food(4, "plat 4","€"))
            food.add(Food(5, "plat 5","€"))
        }
        else if(textTitle.text=="Dessert") {
            food.add(Food(1, "dessert 1","€"))
            food.add(Food(2, "dessert 2","€"))
            food.add(Food(3, "dessert 3","€"))
            food.add(Food(4, "dessert 4","€"))
            food.add(Food(5, "dessert 5","€"))
        }
        return food
    }
}