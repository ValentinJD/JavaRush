package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = console.readLine();
        console.close();
        
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready()){
            String line = new StringBuffer(reader.readLine()).reverse().toString();
            System.out.println(line);
        }
        reader.close();
    }
}
