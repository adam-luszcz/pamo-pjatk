package com.example.extended_bmi_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Recipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe);

        Button backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(Recipe.this, Menu.class);
            startActivity(intent);
        });

        Button recipeShowcaseButton = findViewById(R.id.buyListButton);
        recipeShowcaseButton.setOnClickListener(v -> {
            Intent intent = new Intent(Recipe.this, BuyList.class);
            startActivity(intent);
        });
    }
}
