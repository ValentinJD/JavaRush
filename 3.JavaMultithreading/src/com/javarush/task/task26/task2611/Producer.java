package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable{
    private ConcurrentHashMap <String, String> map;
    
    public Producer(ConcurrentHashMap<String, String> map){
        this.map = map;
    }
    
    public void run(){
        try{
            int key = 0;
            while(true){ 
                String value = String.format("Some text for %d", ++key); 
                map.put(String.valueOf(key), value); 
                Thread.sleep(500); 
            }
        }catch(InterruptedException e){
                System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
        
    }
}