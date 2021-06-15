package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if(string == null) throw new TooShortStringException();
        
        int countTab =0;
        int startIndex =0;
        
        while(true){
            int index = string.indexOf("\t", startIndex);
            if(index != -1) {countTab++;
                startIndex = ++index;
            } else break;
        }
        //System.out.println(countTab);
        if(countTab < 2) throw new TooShortStringException();
        int indexStart = string.indexOf("\t", 0);
        int indexFinish = string.indexOf("\t", indexStart+2);

        
        return string.substring(indexStart+1, indexFinish);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        try{
            System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
        }catch(Exception e){
            System.out.println("Ошибка!");
        }
        
    }
}
