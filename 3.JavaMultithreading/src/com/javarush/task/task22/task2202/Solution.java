package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        try{
            System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        }catch(Exception e){
            
            System.out.println("Что то пошло не так!");
        }
        
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        if(string == null) throw new TooShortStringException();
        int num = string.indexOf(" ");
       //System.out.println(num);
        int num1 = string.indexOf(" ", num+1); 
        //System.out.println(num1);
        int num2 = string.indexOf(" ", num1+1);
        //System.out.println(num2);
        int num3 = string.indexOf(" ", num2+1);
        //System.out.println(num3);
        int num4 = string.indexOf(" ", num3+1);
        //System.out.println(num4);
        if(num4 == -1) num4 = string.length();
        
        int countLabel =0;
        int startIndex =0;
        
        while(true){
            int index = string.indexOf(" ", startIndex);
            if(index != -1) {countLabel++;
                startIndex = ++index;
            } else break;
        }
        if(countLabel < 4 ) throw new TooShortStringException();
        
        
        return string.substring(num+1, num4);
    }

    public static class TooShortStringException extends RuntimeException{
        
    }
}
