package com.bsu;

import java.util.*;

public class Laba3 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter text");
            String ourString;
            StringBuilder strSB = new StringBuilder();
            while (true) {
                ourString = in.nextLine();
                strSB.append(ourString + " ");
                if (ourString.equals("")) {
                    break;
                }
            }
            ourString = func(strSB.toString());
            System.out.println(ourString);
        }
    }

    public static String func(String str) {
        String[] allWords = str.split("[ ,.]", 0);
        Arrays.sort(allWords);
        StringBuilder stSB = new StringBuilder();
        for (String item: allWords) {
            stSB.append(item + " ");
        }
        str = stSB.toString().trim();
        return str;
    }
}