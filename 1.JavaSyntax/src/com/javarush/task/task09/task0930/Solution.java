package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        for (int i=0; i<array.length; i++){ // Сортируем цифры
            String strLeft = array[i];
            String strRight= array[i];
            int numberLeft;
            int numberRight;
            if (isNumber(strLeft)){
                numberLeft = Integer.parseInt(strLeft);
                //System.out.println("Элемент №"+ i + "равен= " + array[i] + "Это число");
                for (int j=0; j<array.length;j++){
                    strRight = array[j];
                    if (isNumber(strRight)){
                        //System.out.println("Элемент №"+ j + "равен= " + array[j] + "Это тоже число");
                        numberRight = Integer.parseInt(strRight);
                        if(numberLeft>numberRight){
                            //System.out.println("Элемент №"+ strLeft + "больше " + strRight);
                            String tmp = array[i];
                            array[i]=array[j];
                            array[j]=tmp;
                            //System.out.println("Меняем местами" + strLeft + " и " + strRight);


                        }
                    }
                }
            }
        }
        for (int i=0; i<array.length; i++){ // Сортируем слова
            String strLeft = array[i];
            String strRight= array[i];
            if (!isNumber(strLeft)){

                for (int j=0;j<array.length;j++){
                    strRight= array[j];
                    if (!isNumber(strRight)){
                        if (!isGreaterThan(strLeft, strRight)){
                            String tmp = array[i];
                            array[i]= array[j];
                            array[j]=tmp;
                        }

                    }
                }

            }


        }
        // напишите тут ваш код
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
