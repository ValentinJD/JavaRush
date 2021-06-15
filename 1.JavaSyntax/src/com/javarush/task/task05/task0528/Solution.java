package com.javarush.task.task05.task0528;

/* 
Вывести на экран сегодняшнюю дату
*/


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Solution {
    public static void main(String[] args) {
        GregorianCalendar calendar = new GregorianCalendar();

        DateFormat df = new SimpleDateFormat("dd MM yyy");
        System.out.println(df.format(calendar.getTime()));
        //напишите тут ваш код
    }
}
