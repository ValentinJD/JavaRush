package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int count=0;
        float sum=0;
        while (true) {
            Scanner s = new Scanner(System.in);
            float number1 = s.nextFloat();
            count++;
            sum = sum + number1;
            float sr = (sum)/count;
            if ((number1==-1)){
                System.out.println(sr);
                break;
            }

        }


        //напишите тут ваш код
    }
}

