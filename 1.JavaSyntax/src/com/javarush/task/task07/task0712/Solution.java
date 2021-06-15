package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> strings = new ArrayList<String>();

        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<10; i++){
            strings.add(b.readLine());
        }

        String min = strings.get(0);
        int indexShort=0;
        for (int i=0; i<strings.size();i++){
            if (min.length()>strings.get(i).length()) {
                min = strings.get(i);
                indexShort=i;

            }
        }
       // System.out.println("индекс самой короткой строки= " + indexShort);
        //System.out.println("самая короткая строка= " + min);

        String max = strings.get(0);
        int indexLong=0;
        for (int i=0; i<strings.size();i++){
            if (max.length()<strings.get(i).length()) {
                max = strings.get(i);
                indexLong=i;

            }
        }
       // System.out.println("индекс самой длинной строки= " + indexLong);
       // System.out.println("самая длинная строка= " + max);

        if (indexShort<indexLong) System.out.println(min);
        else System.out.println(max);
        //напишите тут ваш код
    }
}
