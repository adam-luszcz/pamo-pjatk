package com.example.bmicalculator;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText heightEditText;
    private EditText weightEditText;
    private TextView bmiTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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