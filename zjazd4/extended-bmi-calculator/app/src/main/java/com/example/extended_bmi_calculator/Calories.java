package com.example.extended_bmi_calculator;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class Calories extends AppCompatActivity {
    private EditText weightEditText;
    private EditText heightEditText;
    private EditText ageEditText;
    private CheckBox maleCheckBox;
    private CheckBox femaleCheckBox;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calories);

        resultTextView = findViewById(R.id.resultTextView);
        weightEditText = findViewById(R.id.weightEditText);
        heightEditText = findViewById(R.id.heightEditText);
        Button calculateButton = findViewById(R.id.calculateButton);
        Button backButton = findViewById(R.id.backButton);
        ageEditText = findViewById(R.id.ageEditText);
        maleCheckBox = findViewById(R.id.genderMaleCheckbox);
        femaleCheckBox = findViewById(R.id.genderFemaleCheckbox);

        maleCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (maleCheckBox.isChecked()) {
                    femaleCheckBox.setChecked(false);
                }
            }
        });

        femaleCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (femaleCheckBox.isChecked()) {
                    maleCheckBox.setChecked(false);
                }
            }
        });

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateCalories();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void calculateCalories() {
        String weightStr = weightEditText.getText().toString();
        String heightStr = heightEditText.getText().toString();
        String ageStr = ageEditText.getText().toString();

        if (!weightStr.isEmpty() && !heightStr.isEmpty() && !ageStr.isEmpty()) {
            double weight = Double.parseDouble(weightStr);
            double height = Double.parseDouble(heightStr);
            int age = Integer.parseInt(ageStr);

            double bmr;
            if (maleCheckBox.isChecked()) {
                bmr = 5 + (10 * weight) + (6.25 * height) - (5 * age);
            } else if (femaleCheckBox.isChecked()) {
                bmr = -161 + (10 * weight) + (6.25 * height) - (5 * age);
            } else {
                return;
            }

            resultTextView.setText(String.format(Locale.getDefault(), "%.2f", bmr));
        }
    }
}