package com.example.extended_bmi_calculator;

public class BMICalculator {
    public static double calculateBMI(double height, double weight) {
        if (height > 0) {
            return weight / (height * height);
        }
        return 0;
    }
}
