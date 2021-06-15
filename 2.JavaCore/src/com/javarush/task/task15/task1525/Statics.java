package com.javarush.task.task15.task1525;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Statics {

    public static BufferedReader reader0;
    public static String s;

    static {
        reader0 = new BufferedReader(new InputStreamReader(System.in));
        try {
            s =reader0.readLine(); /* add the path to your source file here */
        } catch (IOException e) {

        }

    }
    public static String FILE_NAME ="test.txt";


}
