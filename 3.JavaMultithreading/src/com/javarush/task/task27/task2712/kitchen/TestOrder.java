package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class TestOrder extends Order {

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException {
        dishes = new ArrayList<>();
        int countOfDishes = ThreadLocalRandom.current().nextInt(Dish.values().length) ;
        //int countOfDishes = (int) (Math.random() * Dish.values().length);
        for (int i = 0; i < countOfDishes; i++) {
            dishes.add(Dish.values()[(int) (Math.random() * Dish.values().length)]);
        }
    }

   /* @Override
    protected void initDishes(){
        // Сделай инициализацию случайным набором блюд.
        List<Dish> list0 = new ArrayList<>();

        List<Dish> list1 = new ArrayList<>();
        list1.add(Dish.Fish);

        List<Dish> list2 = new ArrayList<>();
        list2.add(Dish.Fish);
        list2.add(Dish.Juice);

        List<Dish> list3 = new ArrayList<>();
        list3.add(Dish.Fish);
        list3.add(Dish.Juice);
        list3.add(Dish.Steak);

        List<Dish> list4 = new ArrayList<>();
        list4.add(Dish.Fish);
        list4.add(Dish.Juice);
        list4.add(Dish.Steak);
        list4.add(Dish.Water);

        List<List<Dish>> lists = new ArrayList<>();
        lists.add(list0);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);

        super.dishes = lists.get((int) (Math.random() * lists.size()));





    }*/
}
