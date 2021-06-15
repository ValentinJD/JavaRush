package com.javarush.task.task19.task1908;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args){
        String text = "12 text var2 14 8ю 1";
        Pattern pattern = Pattern.compile("\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            //System.out.println(text.substring(matcher.start(), matcher.end()));
        }
        System.out.println("Hello world!");
    }
}
