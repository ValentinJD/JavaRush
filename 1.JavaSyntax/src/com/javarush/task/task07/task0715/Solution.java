package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String >();
        Collections.addAll(list, "мама", "мыла", "раму");

        for (int i=0; i<list.size(); i++){
            list.add((i+1), "именно");
            i++;
        }

        for (String x : list){
            System.out.println(x);
        }
        //напишите тут ваш код
    }
}
