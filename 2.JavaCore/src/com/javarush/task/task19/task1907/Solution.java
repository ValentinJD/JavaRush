package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader reader = new BufferedReader(new FileReader(fileName)) ;
        int count = 0;
        while (reader.ready()){
            String line = reader.readLine();
            String[] arrStr = line.split("\\p{Punct}+|\\s+");
            for (String s:arrStr){
                //System.out.println("это word?" + s);
                if (s.equals("world")) {
                    count++;
                   //System.out.println("да");
                }
            }
        }
        reader.close();
        System.out.println(count);

    }
}
