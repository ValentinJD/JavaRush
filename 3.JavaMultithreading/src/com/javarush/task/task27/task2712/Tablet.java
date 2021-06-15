package com.javarush.task.task27.task2712;


import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Dish;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.NoAvailableVideoEventDataRow;

import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.IOException;

public class Tablet  {
    private final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    private List<Dish> order ;
    private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();

    public Tablet(int number) {
        this.number = number;
    }

    public void createTestOrder(){ // создание тестового заказа
        TestOrder order = null;
        try {
            order = new TestOrder(this);
        } catch (IOException e) {
            //logger.log(Level.SEVERE,"Console is unavailable.");
        }finally {
            createPartOrder(order);
        }

    }

    public void setOrderQueue(LinkedBlockingQueue<Order> orderQueue) {
        this.queue = orderQueue;
    }

    private void createPartOrder(Order order) {
        if (!order.isEmpty()){
            ConsoleHelper.writeMessage(order.toString());
            //extends Observable
            //setChanged();
            //notifyObservers(order);
            queue.offer(order);
            AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime()*60);
            //System.out.println("Время заказа" + (order.getTotalCookingTime()*60));
            try {
                advertisementManager.processVideos();
            }catch (NoVideoAvailableException e){
                StatisticManager.getInstance().register(new NoAvailableVideoEventDataRow(order.getTotalCookingTime() * 60));
                logger.log(Level.INFO, "No video is available for the order " + order.toString());

            }
        }
    }

    public Order createOrder() {
        Order order = null;

        try {
            order = new Order(this);
        } catch (IOException e) {
            logger.log(Level.SEVERE,"Console is unavailable.");
        }finally {
            createPartOrder(order);
        }

        return order;
    }

    @Override
    public String toString() {
        return "Tablet{" +  "number=" + number +  '}';
    }
}