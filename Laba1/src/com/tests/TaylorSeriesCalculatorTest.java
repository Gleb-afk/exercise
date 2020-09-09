package com.tests;

import com.bsu.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaylorSeriesCalculatorTest {
    @Test
    void test() {
        double x = 5.0;
        double eps = Math.pow(10, -10);
        double calculateValue = Math.cosh(x);
        double actualValue = Main.calculateTaylorSeries(x, eps);
        assertEquals(actualValue, calculateValue);
    }
}
