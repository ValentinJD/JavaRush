package com.javarush.task.task25.task2508;

import java.lang.Thread;

public class TaskManipulator implements Runnable, CustomThreadManipulator{
    private Thread thread;
    
    @Override
    public void run() {
        while(!Thread.currentThread().interrupted()){
            System.out.println(Thread.currentThread().getName());
            try{
               Thread.currentThread().sleep(100);
            }catch(InterruptedException e){
                thread.interrupt();
            }
            
        }
    }
    
    public void start(String threadName){
        this.thread = new Thread(this, threadName);
        this.thread.start();
    }
    
    public void stop(){
       thread.interrupt();
    }
}
