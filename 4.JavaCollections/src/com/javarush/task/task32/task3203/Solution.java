package com.javarush.task.task32.task3203;

/* 
Пишем стек-трейс
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String text = getStackTrace(new IndexOutOfBoundsException("fff"));
        System.out.println(text);
    }

    public static String getStackTrace(Throwable throwable) {
        StackTraceElement[] stack = throwable.getStackTrace();
        StringWriter writer = new StringWriter();
        PrintWriter s = new PrintWriter(writer);
        throwable.printStackTrace(s);
        
        return writer.toString();
        
    }
}