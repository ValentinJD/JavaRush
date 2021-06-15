package com.javarush.task.task18.task1825;                                                                                                                                                                                                                                                                                                            
                                                                                                                                                                                                                                                                                                            
import java.io.*;                                                                                                                                                                                                                                                                                                            
import java.io.FileInputStream;                                                                                                                                                                                                                                                                                                            
import java.io.FileOutputStream;                                                                                                                                                                                                                                                                                                            
import java.io.IOException;                                                                                                                                                                                                                                                                                                            
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
                                                                                                                                                                                                                                                                                                            
/*                                                                                                                                                                                                                                                                                                             
Собираем файл                                                                                                                                                                                                                                                                                                            
*/                                                                                                                                                                                                                                                                                                            
                                                                                                                                                                                                                                                                                                            
public class Solution {
    public static void main(String[] args)throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            try{                                                                                                                                                                                                                                                                                                            
                String fileName = reader.readLine();
                if(fileName.equals("end")) break;
                list.add(fileName);
            }catch(IOException e){System.out.println("Ошибка ввода вывода!");}
        }                                                                                                                                                                                                                                                                                                            
        reader.close();

        String nameFileinList = list.get(0);        
        String[] arrayFile = nameFileinList.split(".part");
        String nameFileFull = arrayFile[0];
        BufferedWriter writer = new BufferedWriter(new FileWriter(nameFileFull)) ;
        Collections.sort(list);

        for (String i: list){
            BufferedReader reader1 = new BufferedReader(new FileReader(i));
            while(reader1.ready()){
                String st = reader1.readLine();
                writer.write(st); 
            }
            reader1.close();
        }
        writer.close();
    }                                                                                                                                                                                                                                                                                                            
                                                                                                                                                                                                                                                                                                                
    public static class Sort implements Comparator<String> {
        @Override                                                                                                                                                                                                                                                                                                            
        public int compare(String a, String b){                                                                                                                                                                                                                                                                                                            
            //Lion.avi.part1                                                                                                                                                                                                                                                                                                            
            String[] arrayb = b.split(".part");                                                                                                                                                                                                                                                                                                            
            int o1 = Integer.parseInt(arrayb[1]);                                                                                                                                                                                                                                                                                                            
            String[] arraya = a.split(".part");                                                                                                                                                                                                                                                                                                            
            int o2 = Integer.parseInt(arraya[1]);
            if (o1 == o2) return 0;
            return o1 > o2 ? -1 : 1;
        }                                                                                                                                                                                                                                                                                                            
    }
}