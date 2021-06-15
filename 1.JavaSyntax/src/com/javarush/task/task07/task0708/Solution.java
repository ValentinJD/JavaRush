package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    private static ArrayList<String> strings = new ArrayList<String>();

    public static void main(String[] args) throws Exception {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<5; i++){
            strings.add(b.readLine());
        }
        String max = strings.get(0);
        for (int i=0; i<strings.size();i++){
            if (max.length()<strings.get(i).length()) max = strings.get(i);
        }
        for (int i=0; i<strings.size(); i++){
            if (strings.get(i).length()==max.length()) System.out.println(strings.get(i));
        }

        //напишите тут ваш код
    }
}
