package com.javarush.task.task27.task2712;


import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {

    private final static int ORDER_CREATING_INTERVAL = 100;
    private final static LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();


    public static void main(String[] args) throws IOException, InterruptedException {
        Locale.setDefault(Locale.ENGLISH);
        Cook cook1 = new Cook("Amigo");
        cook1.setQueue(orderQueue);
        Cook cook2 = new Cook("Bilaboo");
        cook2.setQueue(orderQueue);
        Thread cooker1 = new Thread(cook1);
        Thread cooker2 = new Thread(cook2);
        cooker1.start();
        cooker2.start();


        Waiter officiant = new Waiter();
        cook1.addObserver(officiant);
        cook2.addObserver(officiant);

        List<Tablet> tabletList = new ArrayList<>(5);
        for (int i =0; i<5; i++){
            Tablet tablet = new Tablet(i);
            tablet.setOrderQueue(orderQueue);
            tabletList.add(tablet);
        }

        RandomOrderGeneratorTask task = new RandomOrderGeneratorTask(tabletList, ORDER_CREATING_INTERVAL);
        Thread thread = new Thread(task);
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();

       /*//Mock data
        String[] input = {
                "Fish", System.lineSeparator(), "Water", System.lineSeparator(), "exit", System.lineSeparator(),
                "Juice", System.lineSeparator(), "Steak", System.lineSeparator(), "exit", System.lineSeparator(),
                "Soup", System.lineSeparator(), "exit", System.lineSeparator(),
                "Water", System.lineSeparator(), "exit", System.lineSeparator(),
                "Juice", System.lineSeparator(), "exit", System.lineSeparator()
        };

        byte[][] bytes = Arrays.stream(input).map(String::getBytes).toArray(byte[][]::new);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (byte[] string : bytes) {
            byteArrayOutputStream.write(string, 0, string.length);
        }
        System.setIn(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));


        Cook[] cooks = {
                new Cook("FirstOne"),
                new Cook("SecondOne")};
        Waiter waiter = new Waiter();
        cooks[0].addObserver(waiter);
        cooks[1].addObserver(waiter);

        for (int i = 1; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            int cookNumber = i % 2 == 0 ? 0 : 1;
            tablet.addObserver(cooks[cookNumber]);
            tablet.createOrder();

            CookedOrderEventDataRow cookedOrderEventDataRow =
                    new CookedOrderEventDataRow(tablet.toString(),
                            cooks[cookNumber].toString(),
                            new Random().nextInt(10000), null);
            try {
                Field date = cookedOrderEventDataRow.getClass().getDeclaredField("currentDate");
                if (!date.isAccessible())
                    date.setAccessible(true);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                Date mockDate = simpleDateFormat.parse("1"+i+"-0" + i + "-2002");
                date.set(cookedOrderEventDataRow, mockDate);
                StatisticManager.getInstance().register(cookedOrderEventDataRow);
            } catch (NoSuchFieldException | ParseException | IllegalAccessException e) {
                e.printStackTrace();
            }

        }*/


    }
}