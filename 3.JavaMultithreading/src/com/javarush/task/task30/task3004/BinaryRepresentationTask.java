package com.javarush.task.task30.task3004;

import java.util.concurrent.RecursiveTask;

public class BinaryRepresentationTask extends RecursiveTask<String> {
    private int x;

    public BinaryRepresentationTask(int x) {
        this.x = x;
    }

    @Override
    protected String compute() {


        if (x==0)
            return "0";

        int a = x % 2;
        String result = String.valueOf(a);
        int b = x / 2;
        String s = "";

        if (b > 0) {
          BinaryRepresentationTask  task = new BinaryRepresentationTask(b);
          task.fork();
          s = task.join();
        }

       return  s + result ;


    }
}
