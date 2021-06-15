package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable{ // потребитель
    private TransferQueue<ShareItem> queue;



    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(450);
        } catch (InterruptedException e) {}

        while (!Thread.currentThread().isInterrupted()){
                ShareItem item = null;
                try {
                    item = queue.take();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            System.out.format("Processing %s\n", item.toString());
                
        }

    }


}
