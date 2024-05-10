package com.example.extended_bmi_calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BuyList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.buy_list_screen)

        val ingredients = listOf("Eggs", "Cream", "Butter", "Romaine lettuce", "Croutons", "Parmesan cheese", "Caesar dressing")

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val adapter = BuyListAdapter(ingredients)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val backButton: Button = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            val intent = Intent(this, Recipe::class.java)
            startActivity(intent)
        }
    }
}
