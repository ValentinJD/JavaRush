package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/
import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;
        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(stream);
        //Вызываем функцию, которая ничего не знает о наших манипуляциях
        testString.printSomething();
        //Преобразовываем записанные в наш ByteArray данные в строку
        String result = outputStream.toString();
        //Решаем пример
        String resultte = result.replaceAll("[=]", "");
        String[] numbers = resultte.split(" ");
        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[2]);
        char[] chArray = numbers[1].toCharArray();
        int res;
        if(chArray[0]=='+'){
            res = (a + b);
        } else if(chArray[0]=='-'){
            res = (a - b);
        } else {
            res = a * b;
        };
        
        String output = String.format("%s %s %s = %d", numbers[0], numbers[1], numbers[2], res);
        
        System.out.println(result);
        //Возвращаем все как было
        System.setOut(consoleStream);
        
        System.out.println(output);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

