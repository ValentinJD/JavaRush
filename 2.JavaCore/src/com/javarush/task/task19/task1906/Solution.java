package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameInput = bufferedReader.readLine();
        bufferedReader.close();
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(System.in));
        String fileNameOutput = bufferedReader2.readLine();
        bufferedReader2.close();
        FileReader reader = new FileReader(fileNameInput);
        FileWriter writer = new FileWriter(fileNameOutput);
        while (reader.ready()){
            reader.read();
            int b = reader.read();
            writer.write(b);
        }
        reader.close();
        writer.close();
    }
}
