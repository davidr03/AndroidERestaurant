package fr.isen.ROYER.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AbsListView.RecyclerListener
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActivitySub : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        setTitle(intent.getStringExtra("12345"))


    }
}