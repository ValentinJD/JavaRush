package com.javarush.task.task27.task2712.kitchen;
import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observer;
import java.util.Observable;

public class Waiter implements  Observer { // Оффициант

    @Override
    public void update(Observable o, Object order) { // Observable это будет Cook arg Order
        ConsoleHelper.writeMessage(order + " was cooked by " + o);
        //Your order: [Water] of Tablet{number=5} was cooked by Amigo
    }
}