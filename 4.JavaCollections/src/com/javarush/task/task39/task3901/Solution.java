package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        List<Character> listCH = new ArrayList<>(s.length());
        List<String> stringList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (!listCH.contains(ch)) {
                    listCH.add(ch);
                    stringBuilder.append(ch);
                } else {
                    stringList.add(stringBuilder.toString());
                    listCH.clear();
                    stringBuilder = new StringBuilder("");
                    break;
                }
            }
        }

        return stringList.stream().map(String::length)
                .mapToInt(in -> in).filter(in -> in >= 0).max().orElse(0);
        //в первом цикле берем символы
        // проверяем есть ли символ в листе если нет
        // добавляем его в лист если есть прерываем цикл сохраняем в переменной count
        // и берем следующую букву
        //и конкатенируем
        //
    }
}
