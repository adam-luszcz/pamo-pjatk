package com.example.extended_bmi_calculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void testCalculateBMI() {
        double weight = 70;
        double height = 180;
        double BMI = BMICalculator.calculateBMI(height/100, weight);
        assertEquals(21.60, BMI, 0.01);
    }
}