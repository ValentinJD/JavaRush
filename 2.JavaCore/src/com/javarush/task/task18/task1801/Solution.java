package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(nameFile);
        int max=0;
        while (fileInputStream.available()>0){
            int current = fileInputStream.read();
            if (current>max) max = current;
        }
        System.out.println((byte) max);
        fileInputStream.close();
    }
}
