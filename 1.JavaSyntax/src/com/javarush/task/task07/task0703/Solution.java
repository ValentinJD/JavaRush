package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] str = new String[10];
        int[] arInt = new int[10];
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<10; i++){
            str[i] = buf.readLine();
            arInt[i] = str[i].length();
        }
        for (int i=0; i<arInt.length;i++){
            System.out.println(arInt[i]);
        }
        //напишите тут ваш код
    }
}
