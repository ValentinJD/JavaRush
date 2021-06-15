package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    public static void main(String[] args) {
       // Thread thread4 = threads.get(3);
       //thread4.start();
      /*  for (Thread thread: threads){
            System.out.println(thread.getName() + " стартует");
            thread.start();

            try {
                Thread.sleep(5000);
                System.out.println(thread.getName() + " слип");
                thread.interrupt();
                System.out.println(thread.getName() + " interrupt");
                thread.join();
                System.out.println(thread.getName() + " join");
            } catch (InterruptedException e){}
            System.out.println(thread.getName() + " следующий");

        }*/
    }

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }
}