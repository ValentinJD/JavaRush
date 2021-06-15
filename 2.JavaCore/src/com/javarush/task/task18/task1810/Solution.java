package com.javarush.task.task18.task1810;

/* 
DownloadException
*/
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream=null;
        try{
            while(true){
                fileInputStream = new FileInputStream(reader.readLine());
                int countBytes=fileInputStream.available();
                if(countBytes<1000){
                    reader.close();
            fileInputStream.close();
             throw new DownloadException();
                }
                }
        }catch(IOException e){
            e.printStackTrace();
        } 
    }

    public static class DownloadException extends Exception {

    }
}
