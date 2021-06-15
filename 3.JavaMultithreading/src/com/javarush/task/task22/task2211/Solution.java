package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileInput = args[0];
        String fileOutPut = args[1];
        
        Charset koi8 = Charset.forName("UTF-8");
        Charset windows1251 = Charset.forName("Windows-1251");
        
        FileInputStream readerFile = new FileInputStream(new File(fileInput));
        FileOutputStream writerFile = new FileOutputStream(new File(fileOutPut));
        
        while(readerFile.available() >0){
            byte[] buffer = new byte[1000];
            readerFile.read(buffer);
            String string = new String(buffer, windows1251);
            buffer = string.getBytes(koi8);
            writerFile.write(buffer);
        }
        readerFile.close();
        writerFile.close(); 
    }
}
