package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне1", dateFormat.parse("JAN 1 2012"));
        map.put("Сталлоне2", dateFormat.parse("FEB 2 2012"));
        map.put("Сталлоне3", dateFormat.parse("MAR 3 2012"));
        map.put("Сталлоне4", dateFormat.parse("APR 4 2012"));
        map.put("Сталлоне5", dateFormat.parse("MAY 5 2012"));
        map.put("Сталлоне6", dateFormat.parse("JUN 6 2012"));
        map.put("Сталлоне7", dateFormat.parse("JUL 7 2012"));
        map.put("Сталлоне8", dateFormat.parse("AUG 8 2012"));
        map.put("Сталлоне9", dateFormat.parse("SEP 9 2012"));
        map.put("Сталлоне10", dateFormat.parse("OCT 10 2012"));
        return map;

        //напишите тут ваш код
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        Set<Integer> set = new HashSet<>();
        while (iterator.hasNext()){
            Map.Entry<String, Date> pair = iterator.next();
            Date date = pair.getValue();
            int month = date.getMonth();
            if(month>4 && month<8)iterator.remove();
        }

        //напишите тут ваш код

    }

    public static void main(String[] args) /*throws ParseException*/ {
        /*SimpleDateFormat date = new SimpleDateFormat("MMM d yyyy");
        Date d = new Date();
        int ms = d.getMonth();
        System.out.println(ms);
        System.out.println(date.format(d));
        Map<String, Date> map =createMap();
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Date> pair = iterator.next();
            Date dat = pair.getValue();
            int month = dat.getMonth();
            System.out.println(dat);
            System.out.println(month);
        }*/
    }
}

