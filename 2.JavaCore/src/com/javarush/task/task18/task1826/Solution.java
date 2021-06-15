package com.javarush.task.task18.task1826;

/* 
Шифровка
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(args[1]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[2]));
        
        while(reader.ready()){
            int ourByte = reader.read();
            if(args[0].equals("-e")){
                ourByte= ~ourByte;
            } else if (args[0].equals("-d")){
                ourByte= ~ourByte;
            }
            writer.write((byte) ourByte);
        }
        reader.close();
        writer.close();

    }

}
