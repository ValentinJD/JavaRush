package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileNameInput = scanner.next();
        scanner.close();
       // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); // C:\Users\Валентин\Desktop\test.txt
        //String fileNameInput = bufferedReader.readLine();

        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(System.in)); // C:\Users\Валентин\Desktop\outputTest.txt
        String fileNameOutput = bufferedReader2.readLine();
        //bufferedReader.close();
        bufferedReader2.close();

        BufferedReader reader = new BufferedReader(new FileReader(fileNameInput));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileNameOutput));
        while (reader.ready()){
            String line = reader.readLine();
            String[] arrStr = line.split("\\b");

            for (String s:arrStr){
                if (Pattern.matches("\\d++",s)){
                    writer.write(s + " ");
                    //System.out.println(s + " ");
                }
            }
        }
        writer.close();
       reader.close();
    }
}
