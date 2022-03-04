package fr.isen.ROYER.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onStop() {
        super.onStop()
        Log.d("homeActivity","homeStop")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.`activity_home`)


        val entree = findViewById<TextView>(R.id.Entree)
        val plat = findViewById<TextView>(R.id.Plat)
        val dessert = findViewById<TextView>(R.id.Dessert)
        entree.setOnClickListener {
            /**
             * info-bulle ou l'on affiche du texte
             * creer une nouvelle activité val intent ...
             * lancer la nouvelle activitée startActivity()
             */
            Toast.makeText(this, "Entree is clicked", Toast.LENGTH_SHORT).show()
            startCategory(getString(R.string.entr_e))
        }




        plat.setOnClickListener {
            Toast.makeText(this, getString(R.string.plats), Toast.LENGTH_SHORT).show()
            startCategory(getString(R.string.plats))

        }
        dessert.setOnClickListener {
            Toast.makeText(this, "Desserts is clicked", Toast.LENGTH_SHORT).show()
            startCategory(getString(R.string.dessert))
        }
    }

    private fun startCategory(category: String) {
        val intent = Intent(this, ActivitySub::class.java).apply { putExtra("12345", category) }
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("homeActivity","actimorte")
    }
}