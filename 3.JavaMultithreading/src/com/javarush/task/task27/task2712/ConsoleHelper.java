package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) { // для вывода message в консоль
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return bufferedReader.readLine();
    }// - для чтения строки с консоли

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> allDishesForOrder = new ArrayList<Dish>();

        String dish;
        
        System.out.println("Выберите блюдо пожалуйста!");
        System.out.println(Dish.allDishesToString());

        while (true) {
            
            dish = readString();
            if (dish.equals("exit")) {
                break;
            }
            try {
                allDishesForOrder.add(Dish.valueOf(dish));
            } catch (IllegalArgumentException e) {
                System.out.println("Извините в меню отсутсвует данное блюдо.");
            }
        }
        return allDishesForOrder;
    } // - просит пользователя выбрать блюдо и добавляет его в список.


}
