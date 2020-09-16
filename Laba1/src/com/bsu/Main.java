package com.bsu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int k;
        double x;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Write your k:");
            k = scanner.nextInt();
            if (k <= 0) {
                throw new InvalidParameterException("should be more than 0");
            }
            System.out.println("Let me know your x:");
            x = scanner.nextDouble();
            double eps = Math.pow(10, -k);
            double calculatedValue = calculateTaylorSeries(x, eps);
            double actualValue = Math.sinh(x);
            System.out.println("Calculated value: " + formatValue(calculatedValue));
            System.out.println("Actual value: " + formatValue(actualValue));
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public static double calculateTaylorSeries(double x, double eps) {
        double seriesSum = 0.0;
        double nextTerm = x;
        int n = 1;
        while (nextTerm >= eps) {
            seriesSum += nextTerm;
            n += 2;
            nextTerm = nextTerm * x * x / (n * (n - 1));
        }
        return seriesSum;
    }

    private static String formatValue(double value) {
        return String.format("%.3f", value);
    }

}
