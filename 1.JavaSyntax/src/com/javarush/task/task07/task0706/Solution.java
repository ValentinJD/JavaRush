package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int[] array = new int[15];
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<array.length; i++){
            array[i] = Integer.parseInt(b.readLine());
        }
        int sumEven=0;
        int sumOdd=0;
        for (int i=0; i<array.length; i++){
            if (i%2==0) sumEven = sumEven + array[i];
            else sumOdd = sumOdd + array[i];
        }
        if (sumEven>sumOdd) System.out.println("В домах с четными номерами проживает больше жителей.");
        else System.out.println("В домах с нечетными номерами проживает больше жителей.");
        //напишите тут ваш код
    }
}
