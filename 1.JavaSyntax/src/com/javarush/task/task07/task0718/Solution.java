package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<10;i++){
            list.add(reader.readLine());
        }

        String str;
        Boolean b = false;
        int x=0;
        int y=list.size()-1;
        int str1=0;
        for (int i=0; i<list.size(); i++){ // если упорядоченный то true
            str = list.get(i);
            if (i<list.size()-1) str1 = list.get(i+1).length();
            if(str.length()>str1) {
                b = true;
                x = i+1;
                break;
            }
        }

        if (b)System.out.println(x);



        //напишите тут ваш код
    }
}

