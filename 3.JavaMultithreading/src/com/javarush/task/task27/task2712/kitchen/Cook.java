package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Objects;
import java.util.Observable;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable  {
    private String name;
    private boolean busy;
    private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();

    public Cook(String nameCook) {
        this.name = nameCook;

    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public boolean isBusy() {
        return busy;
    }

    @Override
    public String toString() {
        return  name;
    }

    public void startCookingOrder(Order arg){// arg Order
        busy = true; // повар занят

        Order order = (Order) arg;

        ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + order.getTotalCookingTime() + "min");

        StatisticManager.getInstance().register(
                new CookedOrderEventDataRow(
                        null,
                        name,
                        order.getTotalCookingTime()*60,
                        order.dishes
                )
        );

        setChanged();
        notifyObservers(order);

        try {
            Thread.sleep(10 * order.getTotalCookingTime());
        } catch (InterruptedException ignored) {}

        busy = false;
    }

    @Override
    public void run() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
               // Set<Cook> cooks = StatisticManager.getInstance().getCooks();
                while (true){
                    if (!queue.isEmpty()) {
                            if (!isBusy()) startCookingOrder(Objects.requireNonNull(queue.poll()));
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ignored) {
                    }
                }
            }
        });
        thread.setDaemon(true);
        thread.start();

    }
}
