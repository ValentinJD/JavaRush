package com.javarush.task.task16.task1632;

public class Thread4 extends Thread implements Message {
    public void showWarning(){
        this.interrupt();

    }

    @Override
    public void run(){

        while (true){
            if (isInterrupted()){
                //System.out.println("Thread4");
                if (this.isAlive()) {
                    //System.out.println("ТЕПЕРЬ МЕРТВА");
                    return;
                }
            }

        }

    }
}
