package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while (reader.ready()){
            String line = reader.readLine();
            String[] array = line.split(" ");
            int year = Integer.parseInt(array[array.length-1]);
            int month = Integer.parseInt(array[array.length-2]);
            int day = Integer.parseInt(array[array.length-3]);
            String[] names = line.split(" \\d+");
            
            String name = names[0];
            Date date = new SimpleDateFormat("d M y").parse("" + day + " " + month + " " + year);
            PEOPLE.add(new Person(name, date));
        }
        reader.close();
        /*for (Person p:PEOPLE){
            System.out.println(p);
        }*/

    }
}
