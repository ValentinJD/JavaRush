package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] inrArray = new int[10];
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<10; i++){
            inrArray[i] = Integer.parseInt(b.readLine());
        }
        for (int i=inrArray.length-1; i>=0; i--){
            System.out.println(inrArray[i]);
        }
        //напишите тут ваш код
    }
}

