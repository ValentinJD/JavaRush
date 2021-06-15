package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Thread5 extends Thread {
    @Override
    public void run(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String bool = "";
       int sum = 0;
        int i;
        while (true){
            try {
                //System.out.println("Thread5");
                //System.out.println("Введите чило либо для выхода N");
                bool = reader.readLine();

                if (bool.equals("N")) break;
                i = Integer.parseInt(bool);
                sum = sum + i;
            } catch (IOException e ){}

        }
        System.out.println(sum);
    }
}
