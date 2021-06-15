package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.*;


public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;
    
    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    protected void initDishes() throws IOException { // создатель списка блюд без участия человека
       this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString(){
        if (dishes.size()== 0){
            return "";
        } else return ("Your order: " + dishes.toString() +  " of " +  tablet.toString());
        //Your order: [Juice, Fish] of Tablet{number=5}
    }

    public boolean isEmpty(){
        if (dishes == null || dishes.size() == 0){
            return true;
        }else return false;
    }

    public int getTotalCookingTime(){

        int time = 0; // в минутах
        for (Dish dish: dishes){
            time+=dish.getDuration();
        }
        return time;
    }

    public List<Dish> getDishes() {
        return dishes;
    }


}