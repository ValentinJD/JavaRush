package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
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
        String resultte = result.replaceAll("te", "??");
        
        System.out.println(result);
        //Возвращаем все как было
        System.setOut(consoleStream);
        System.out.println(resultte);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
