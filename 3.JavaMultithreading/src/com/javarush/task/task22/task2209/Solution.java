package com.javarush.task.task22.task2209;

/* 
Составить цепочку слов
*/
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // C:\Users\Валентин\Desktop\test.txt
        List<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(reader.readLine());
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        while (fileReader.ready()){
            String string = fileReader.readLine();
            String[] array = string.split(" ");
            for (String s:array){
                String str1 = s.replaceAll("\\uFEFF", "");
                String str2 = str1.trim();
                list.add(str2);
            }
        }
        fileReader.close();
        
        //...
        StringBuilder result = getLine((String[])list.toArray(new String[0]));
        System.out.println(result.toString());
    }

  public static StringBuilder getLine(String... words){
    StringBuilder build = new StringBuilder();
    if(words.length == 0) return build;

    List<String> listOne = new ArrayList<String>(Arrays.asList(words));
    List<String> listTwo = new ArrayList<String>(Arrays.asList(words)); 
    List<String> listThree = new ArrayList<String>();
    List<String> listFour = new ArrayList<String>(Arrays.asList(words));
    
    String stringOne = null;
    String stringTwo = null;    
    int x=0;
    int y=0;
    for(int i=0; i<listOne.size(); i++){     
      if(x==0) stringOne = listOne.get(i); 
      char a = stringOne.toLowerCase().charAt(stringOne.length()-1);
      for(int j = 0; j <listTwo.size(); j++){
        if(y==0) j++;
        if(listTwo.get(j) == null) continue;
        stringTwo = listTwo.get(j);         
        // System.out.println(stringOne + " " + stringTwo + " ");
         char b = stringTwo.toLowerCase().charAt(0); 
         if(a == b) {
           if(x==0){ 
               build.append(stringOne + " " + stringTwo);
               listThree.add(stringOne);
               listThree.add(stringTwo);
           }
           else { 
               build.append(" " + stringTwo); 
               listThree.add(stringTwo);
           }
           listTwo.remove(0); 
           listTwo.add(0, null);
           listTwo.remove(j);  
           listTwo.add(j, null);
           stringOne = stringTwo;
           j = listTwo.size()-1;                  
         }
         y++;  
      } 
       listOne.remove(i);
       listOne.add(0, null);
       x++;
    }
    
    for(String s: listFour){
        if(!listThree.contains(s)) build.append(" "+ s);
    }
    return build;
  }
}
