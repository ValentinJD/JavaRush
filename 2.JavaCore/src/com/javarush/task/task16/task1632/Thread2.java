package com.javarush.task.task16.task1632;

public class Thread2 extends Thread  {
    @Override
    public void run() {
        //System.out.println("Thread2");
        if (isInterrupted()) {
            new InterruptedException();
            System.out.println("InterruptedException");
        }
    }
}
