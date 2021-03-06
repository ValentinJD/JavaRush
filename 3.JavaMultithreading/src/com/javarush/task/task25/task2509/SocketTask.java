package com.javarush.task.task25.task2509;

import java.net.Socket;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.io.*;

public abstract class SocketTask<T> implements CancellableTask<T> {
    private Socket socket;

    protected synchronized void setSocket(Socket socket) {
        this.socket = socket;
    }

    public synchronized void cancel() {
        try{
            socket.close();
        }catch(IOException e){
            
        }
        
        //close all resources here
    }

    public RunnableFuture<T> newTask() {
        return new FutureTask<T>(this) {
            public boolean cancel(boolean mayInterruptIfRunning) {
                try{
                    socket.close();
                }catch(IOException e){
                    
                }finally{
                    //SocketTask.super.cancel();
                }
                //close all resources here by using proper SocketTask method
                //call super-class method in finally block
                return false;
            }
        };
    }
}