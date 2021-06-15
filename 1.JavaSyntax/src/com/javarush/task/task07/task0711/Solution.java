package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings = new ArrayList<String>();

        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<5; i++){
            strings.add(b.readLine());
        }
        String end;
        for (int i=0; i<13;i++){
          end = strings.get(4);
          strings.remove(4);
          strings.add(0, end);
        }
        for (int i=0; i<strings.size(); i++){
            System.out.println(strings.get(i));
        }

        //напишите тут ваш код
    }
}
