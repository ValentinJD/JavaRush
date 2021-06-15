package com.javarush.task.task27.task2709;
import java.lang.InterruptedException;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() {
        try{
            while (!isValuePresent)
            this.wait();
        } catch(InterruptedException e){}
        isValuePresent = false;
        try{
            this.notifyAll();
        } catch(Exception e){  }
        System.out.println("Got: " + value);
        return value;
    }

    public synchronized void put(int value) {
        try{
            while (isValuePresent)
            this.wait();
        } catch(InterruptedException e){}
        this.value = value;
        isValuePresent = true;
        try{
            this.notifyAll();
        } catch(Exception e){  }
        System.out.println("Put: " + value);


        
    }
}
