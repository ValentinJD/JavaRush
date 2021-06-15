package com.javarush.task.task19.task1925;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.*;
import java.util.*;
/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        List<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        
        while (reader.ready()){
            String line = reader.readLine();
            String[] array = line.split(" ");
            for(int i=0; i<array.length; i++){
                String s = array[i]; //.replace("\uFEFF", "")
                if(s.matches("\\S{7,}")){
                    list.add(s);
                }
            }
        }
        
        for(int i=0; i<list.size(); i++){
            writer.write(list.get(i));
            if(i!=(list.size()-1))writer.write(",");
        }
        reader.close();
        writer.close();
    }
}
