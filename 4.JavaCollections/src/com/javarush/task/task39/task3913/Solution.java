package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        try {
            LogParser logParser = new LogParser(Paths.get("c:/logs/"));
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
            Date after = format.parse("30.01.2014 12:56:22"); // c
            Date before = format.parse("14.11.2015 07:08:01"); // по

            System.out.println("get ip for event = \"[any_event]\" and date between \"[after]\" and \"[before]\"");
            logParser.execute("get ip for event = \"[any_event]\" and date between \"[after]\" and \"[before]\"")
                    .forEach(System.out::println);




        }catch (Exception e){
            e.printStackTrace();
        }


    }
}