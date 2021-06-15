package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = new int[20];

        for (int i=0; i<array.length; i++){
            array[i] = Integer.parseInt(reader.readLine());
        }

        int maximum = array[0];
        int minimum = array[0];

        for (int x=0; x<array.length; x++){

            if (minimum>array[x]) minimum = array[x];
        }
        for (int x=0; x<array.length; x++){

            if (maximum<array[x]) maximum = array[x];
        }


        //напишите тут ваш код

        System.out.print(maximum + " " + minimum);
    }
}
