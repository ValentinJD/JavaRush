package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        char[] array = string.toCharArray();
        for(int i=0; i<array.length; i++){
            char m = array[i];
            if(array[0] == ' ' && array[1] !=' ' && i==0) {
                array[1]=((array[1]+"").toUpperCase()).charAt(0);
            } else if(array[i]==' ' && array[i+1]!=' '){
                array[i+1]=((array[i+1]+"").toUpperCase()).charAt(0);
            }

        }
        System.out.println(array);

        //напишите тут ваш код
    }
}
