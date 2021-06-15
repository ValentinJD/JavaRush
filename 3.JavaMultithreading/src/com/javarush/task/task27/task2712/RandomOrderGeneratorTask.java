package com.javarush.task.task27.task2712;

import java.util.*;

public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> tabletList = new ArrayList<>();
    int ORDER_CREATING_INTERVAL;

    public RandomOrderGeneratorTask(List<Tablet> tabletList, int ORDER_CREATING_INTERVAL) {
        this.tabletList = tabletList;
        this.ORDER_CREATING_INTERVAL = ORDER_CREATING_INTERVAL;
    }

    @Override
    public void run(){
        // выбор случайного планшета
        Tablet tablet = tabletList.get((int) (Math.random() * tabletList.size()));
        while (!Thread.currentThread().isInterrupted()){
            //создаем заказ каждые ORDER_CREATING_INTERVAL милисекунд
            tablet.createTestOrder();
            try {
                Thread.sleep(ORDER_CREATING_INTERVAL);
            } catch (InterruptedException e) {
                //e.printStackTrace();
                break;
            }
        }
    }
}