package com.javarush.task.task22.task2208;

import java.util.*;
import java.lang.*;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder where = new StringBuilder();
        
        Iterator iterator = params.entrySet().iterator();
        
        while(iterator.hasNext()){
            Map.Entry<String, String> pair = (Map.Entry<String, String>) iterator.next();
            String key = pair.getKey();
            String value = pair.getValue();
            if(key == null || value == null) continue;
            where.append(key);
            where.append(" = \'");
            where.append(value);
            where.append("\'");
            if(iterator.hasNext()){
                where.append(" and ");
            }
        }
        return where.toString();
    }
}
