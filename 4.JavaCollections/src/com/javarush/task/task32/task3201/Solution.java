package com.javarush.task.task32.task3201;

/* 
Запись в существующий файл
*/
import java.io.RandomAccessFile;
import java.io.*;

public class Solution {
    public static void main(String... args) throws FileNotFoundException, IOException{
        RandomAccessFile file = new RandomAccessFile(args[0], "rw");
        int number = Integer.parseInt(args[1]);
        file.seek(number);
        String text = args[2];
        char[] array = text.toCharArray();
        long currentLengthFile = file.length();
        long needLengthFile = (file.length() - number + text.length());
        
        if (file.length()<number) 
            file.seek(file.length()); 
        else file.seek(number);
        
        
            
            
        for(char ch: array){
            file.write(ch);
        }
    }
}
