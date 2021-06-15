package com.javarush.task.task08.task0827;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("JANUARY 2 2020"));
    }

    public static boolean isDateOdd(String date) throws ParseException  {
        GregorianCalendar calendar = new GregorianCalendar();
        Date dat = new Date(date);
        calendar.setTime(dat);
        int nDay = calendar.get(Calendar.DAY_OF_YEAR);
        //System.out.println(nDay);

        return nDay % 2 != 0;
    }
}
