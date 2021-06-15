package com.javarush.task.task19.task1923;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.*;
/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        
        while (reader.ready()){
            String line = reader.readLine();
            String[] array = line.split(" ");
            for(String s:array){
                String sBOM = s.replace("\uFEFF", "");
               if(sBOM.matches("(\\D*\\d+\\D*)+")){
                   writer.write(sBOM + " ");
               } 
            }
        }
        reader.close();
        writer.close();
    }
}
