package com.javarush.task.task32.task3210;

/* 
Используем RandomAccessFile
*/

import java.io.RandomAccessFile;
import java.io.*;

public class Solution {
    public static void main(String... args) throws FileNotFoundException, IOException{
        RandomAccessFile file = new RandomAccessFile(args[0], "rw");
        int number = Integer.parseInt(args[1]);
        String text = args[2];
        char[] array = text.toCharArray();
        byte[] array2 = new byte[array.length];
        file.seek(number);
        file.read(array2, 0, array.length);
        
        String text2 = new String(array2);
        
        if(text.equals(text2)){
            file.seek(file.length());
            file.write("true".getBytes());
        }else{
            file.seek(file.length());
            file.write("false".getBytes());
        }
    }
}
