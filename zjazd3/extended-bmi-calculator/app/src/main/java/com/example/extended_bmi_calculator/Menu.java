package com.example.extended_bmi_calculator;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Button bmiCalculatorButton = findViewById(R.id.bmiCalculatorButton);
        bmiCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, BMI.class);
                startActivity(intent);
            }
        });

        Button calorieCalculatorButton = findViewById(R.id.calorieCalculatorButton);
        calorieCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Calories.class);
                startActivity(intent);
            }
        });

        Button recipeShowcaseButton = findViewById(R.id.recipeRecommendationsButton);
        recipeShowcaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Recipe.class);
                startActivity(intent);
            }
        });
    }
}
