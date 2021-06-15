package com.javarush.task.task09.task0929;

import java.io.*;

/* 
Обогатим код функциональностью!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFileName;
        InputStream fileInputStream;
        String destinationFileName=null;
        try {
            sourceFileName =  reader.readLine();// "C:\\"; //
            fileInputStream = getInputStream(sourceFileName);
            destinationFileName = reader.readLine(); // "C:\\Users\\Валентин\\Desktop\\test1.txt";  //
        } catch (FileNotFoundException e){
            System.out.println("Файл не существует.");
            sourceFileName =  reader.readLine(); // "C:\\Users\\Валентин\\Desktop\\test.txt"; //
            fileInputStream = getInputStream(sourceFileName);
            destinationFileName =  reader.readLine(); //"C:\\Users\\Валентин\\Desktop\\test1.txt";  //
        }

        OutputStream fileOutputStream = getOutputStream(destinationFileName);

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            fileOutputStream.write(data);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }

    public static InputStream getInputStream(String fileName) throws IOException {
        return new FileInputStream(fileName);
    }

    public static OutputStream getOutputStream(String fileName) throws IOException {
        return new FileOutputStream(fileName);
    }
}

