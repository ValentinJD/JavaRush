package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        ArrayList<String> strings = new ArrayList<String>();

        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<5; i++){
            strings.add(b.readLine());
        }
        String min = strings.get(0);
        for (int i=0; i<strings.size();i++){
            if (min.length()>strings.get(i).length()) min = strings.get(i);
        }
        for (int i=0; i<strings.size(); i++){
            if (strings.get(i).length()==min.length()) System.out.println(strings.get(i));
        }
        //напишите тут ваш код
    }
}
