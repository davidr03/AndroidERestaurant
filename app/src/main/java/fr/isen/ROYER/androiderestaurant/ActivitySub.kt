package fr.isen.ROYER.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ActivitySub : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val texttitle = findViewById<TextView>(R.id.title)
        texttitle.text=intent.getStringExtra("12345")
        setTitle(intent.getStringExtra("12345"))

        val  food = CreerMesLigne()
        var monRecycler: RecyclerView = findViewById(R.id.listeFood)
        monRecycler.layoutManager = LinearLayoutManager(this)
        monRecycler.adapter = FoodAdapter(food.toTypedArray())
        {
            Toast.makeText(this, "Vous avez sélectionné ${it.nom}", Toast.LENGTH_SHORT).show()
        }

       /* val back = findViewById<Button>(R.id.backMain)

        // set on-click listener
        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }*/
    }



    fun CreerMesLigne() :ArrayList<Food> {
        val food = ArrayList<Food>()
        food.add(Food(1, "Loup"))
        food.add(Food(2, "Gorille"))
        food.add(Food(3, "Eléphant"))
        food.add(Food(4, "Tigre"))
        food.add(Food(5, "Dauphin"))

        return food
    }
}