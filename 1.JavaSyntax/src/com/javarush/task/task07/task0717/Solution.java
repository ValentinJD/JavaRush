package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<10; i++){
            list.add(reader.readLine());
        }
        // Считать строки с консоли и объявить ArrayList list тут

        ArrayList<String> result = doubleValues(list);

        // Вывести на экран result
        for (String x: result){
            System.out.println(x);
        }
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        int x = 2*list.size()-1;
        for (int i=0; i<x;i++){
            String str = list.get(i);
            list.add((i++), str);
        }
        //напишите тут ваш код
        return list;
    }
}
