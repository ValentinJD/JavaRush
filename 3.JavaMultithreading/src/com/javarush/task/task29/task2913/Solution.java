package com.javarush.task.task29.task2913;

import java.util.*;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        StringBuilder stringBuilder = new StringBuilder();


        if (a < b) {
            for (int i = a; i <= b; i++) {
                if (i != (b)) {
                    stringBuilder.append(i + " ");
                } else {
                    stringBuilder.append(i + "");
                }
            }
        }
        if (a > b) { // a = 5 b = 1
            for (int i = a; i >= b; i--) {
                if (i != (b)) {
                    stringBuilder.append(i + " ");
                } else {
                    stringBuilder.append(i + "");
                }
            }
        }




        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}