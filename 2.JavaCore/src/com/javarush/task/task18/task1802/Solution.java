package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(nameFile);
        int min=0;
        int i;
        int x=0;
        while (fileInputStream.available()>0){
            int current = fileInputStream.read();
            if (x==0)min =current;
            x++;
            if (current<min) min = current;
        }
        System.out.println((byte) min);
        fileInputStream.close();
    }
}
