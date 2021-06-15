package com.javarush.task.task19.task1922;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.*;


/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        String fileName = readerConsole.readLine();
        readerConsole.close();
        
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
         
        while (reader.ready()){
            String line = reader.readLine();
            String[] array = line.split(" ");
            int count = 0;
            for(String s:array){
                for(String word: words){
                    if(s.equals(word)) count++;
                }
            }
            if(count==2)System.out.println(line);
            count = 0;
        }
        reader.close();
    }
}
