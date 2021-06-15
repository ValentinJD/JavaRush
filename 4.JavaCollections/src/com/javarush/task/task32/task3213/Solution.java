package com.javarush.task.task32.task3213;

import java.io.*;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        if (reader == null) return "";
        BufferedReader buffer = new BufferedReader(reader);
        String str;
        str = buffer.readLine();
        char[] array = str.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char ch: array){
            ch +=key;
            builder.append(ch);
        }
        return builder.toString();
    }
}
