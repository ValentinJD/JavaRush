package com.javarush.task.task31.task3109;

import java.util.Properties;
import java.io.*;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties properties = new Properties();
        
        try{
                 FileInputStream  input =   new FileInputStream(fileName);
                 if( fileName.endsWith(".xml"))
                 properties.loadFromXML(input);
                 else properties.load(input);
            
        }catch (IOException e) {
            return properties;
        }catch (Exception e) {
            return properties;
        }
        return properties;
    }
}
