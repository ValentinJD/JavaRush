package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(reader.readLine()); // Количество чисел
        if (m>0) {
            int maximum = Integer.parseInt(reader.readLine());
            int n;
            for (int i=1; i<m; i++){
                    n = Integer.parseInt(reader.readLine());
                    if (n>maximum) maximum = n;
                }
            System.out.println(maximum);
            }

        }

        //напишите тут ваш код


    }

