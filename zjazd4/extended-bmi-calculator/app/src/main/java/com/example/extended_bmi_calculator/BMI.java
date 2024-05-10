package com.example.extended_bmi_calculator;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class BMI extends AppCompatActivity {
    private EditText heightEditText;
    private EditText weightEditText;
    private TextView bmiTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);
        Button backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        heightEditText = findViewById(R.id.heightEditText);
        heightEditText.addTextChangedListener(bmiTextWatcher);

        weightEditText = findViewById(R.id.weightEditText);
        weightEditText.addTextChangedListener(bmiTextWatcher);

        bmiTextView = findViewById(R.id.bmiTextView);

    }

    private void calculateAndDisplayBMI() {
        String weightStr = weightEditText.getText().toString();
        String heightStr = heightEditText.getText().toString();

        if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
            double weight = Double.parseDouble(weightStr);
            double height = Double.parseDouble(heightStr) / 100;

            if (height > 0) {
                double bmi = weight / (height * height);
                bmiTextView.setText(String.format(Locale.getDefault(), "%.1f", bmi));
            }
        }
    }

    private final TextWatcher bmiTextWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {
            calculateAndDisplayBMI();
        }

        @Override
        public void afterTextChanged(Editable s) { }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) { }
    };

}
