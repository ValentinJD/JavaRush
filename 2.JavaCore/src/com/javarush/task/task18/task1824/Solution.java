package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/
import java.io.*;

public class Solution {
    public static void main  (String[] args) throws IOException {
        BufferedReader input;
        while(true){
            input = new BufferedReader(new InputStreamReader(System.in));
            String fileName= input.readLine();
            BufferedReader reader=null;
           try{
                reader=new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
                reader.close();
                File file = new File(fileName);
                //if(file.exists()) throw new FileNotFoundException();
           }catch(FileNotFoundException e){
            System.out.println(fileName);
            break;
           }
        }
        input.close();
   }
}
