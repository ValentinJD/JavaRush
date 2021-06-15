package com.javarush.task.task07.task0702;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Массив из строчек в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] str = new String[10];
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<8;i++){
            str[i] = buffer.readLine();
        }
        for (int i=str.length-1; i>=0; i--){
            System.out.println(str[i]);
        }
        //напишите тут ваш код
    }
}