package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.regex.*;
import java.util.*;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception{
        //BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        //String fileName = consoleReader.readLine();
        String fileName = "C:\\Users\\Валентин\\Desktop\\test.txt";
        FileInputStream inputStream = new FileInputStream(fileName);
        load(inputStream);
        //implement this method - реализуйте этот метод
        String outputfileName = "C:\\Users\\Валентин\\Desktop\\testOutput.txt";
        FileOutputStream outputStream = new FileOutputStream(outputfileName);
        save(outputStream);
        
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
        prop.putAll(properties);
        prop.store(outputStream, "Test");
        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
        Properties prop = new Properties();
        prop.load(inputStream);
        for (final String name: prop.stringPropertyNames())
        properties.put(name, prop.getProperty(name));
        //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.fillInPropertiesMap();

    }
}
