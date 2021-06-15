package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileNameInput = scanner.next();


        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(System.in)); // C:\Users\Валентин\Desktop\outputTest.txt
        String fileNameOutput = bufferedReader2.readLine();
        scanner.close();
        bufferedReader2.close();

        BufferedReader reader = new BufferedReader(new FileReader(fileNameInput));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileNameOutput));
        while (reader.ready()){
            String line = reader.readLine();
            String lineReplace = line.replaceAll("\\.", "!");
            writer.write(lineReplace);
        }
        writer.close();
        reader.close();


    }
}
