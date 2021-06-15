package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String n1;
        String n2;
        int number1;
        int number2;



        try {
            number1 = Integer.parseInt(bufferedReader.readLine());
            if(number1 <= 0) throw new Exception();
            number2 = Integer.parseInt(bufferedReader.readLine());
            if(number2 <= 0) throw new Exception();
            System.out.println(gcd(number1, number2));

        } catch (Exception e){
            //System.out.println("Невозможно преобразовать числа в положительные");

        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        int x = a % b;
        return gcd(b, x);
    }
}
