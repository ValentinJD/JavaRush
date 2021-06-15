package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array20 = new int[20];
        int[] array10_1 = new int[10];
        int[] array10_2 = new int[10];
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<array20.length; i++){
            array20[i] = Integer.parseInt(b.readLine());
        }
        array10_1 = Arrays.copyOfRange(array20, 0,10);
        array10_2 = Arrays.copyOfRange(array20, 10,20);
        for (int i=0; i<array10_2.length; i++){
            System.out.println(array10_2[i]);
        }
        //напишите тут ваш код
    }
}
