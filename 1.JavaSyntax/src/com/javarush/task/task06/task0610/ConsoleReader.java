package com.javarush.task.task06.task0610;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Класс ConsoleReader
*/

public class ConsoleReader {
    public static String readString() throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String s = buffer.readLine();
        return s;
        //напишите тут ваш код

    }

    public static int readInt() throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String s = buffer.readLine();
        int i = Integer.parseInt(s);
        return i;
        //напишите тут ваш код

    }

    public static double readDouble() throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String s = buffer.readLine();
        double d = Double.parseDouble(s);
        return d;
        //напишите тут ваш код

    }

    public static boolean readBoolean() throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String s = buffer.readLine();
        boolean b;
        if (s.equals("true")) b= true;
        else b = false;
        return  b;
        //напишите тут ваш код

    }

    public static void main(String[] args) throws Exception {

    }
}
