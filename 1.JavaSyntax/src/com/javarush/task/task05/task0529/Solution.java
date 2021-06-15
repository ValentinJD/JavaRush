package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int sum=0;
        int number=0;
        while (true)
        {
            String s = buffer.readLine();

            try
            {
                number = Integer.parseInt(s.trim());
            }
            catch (NumberFormatException nfe)
            {
               // System.out.println("Что то не так");
            }

            if (s.equals("сумма")) {
                System.out.println(sum);
                break;
            } else {
                sum = sum + number;

            }

        }
        //напишите тут ваш код
    }
}
