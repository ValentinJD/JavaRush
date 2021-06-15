package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/
import java.io.*;
import java.util.*;
import java.util.Arrays;


public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String line = outputStream.toString();
        String[] array = line.split("\\n");
        List<String> list = new ArrayList<>();
        for(String s:array){
            list.add(s);
        }
        int count=0;
        String advertising = "JavaRush - курсы Java онлайн";
        for(int i=0; i<list.size(); i++){
            if(i==0) count= count+2;
            else count= count+3;
            if(count<list.size())list.add(count, advertising);
        }
        System.setOut(consoleStream);
        
        for(String s:list){
            System.out.println(s);
        }
        
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");//0
            System.out.println("second");//1
            System.out.println("third");//2
            System.out.println("fourth");//3
            System.out.println("fifth");//4
        }
    }
}
