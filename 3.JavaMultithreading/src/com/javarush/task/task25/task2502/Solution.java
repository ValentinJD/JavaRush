package com.javarush.task.task25.task2502;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            wheels = new ArrayList<>();
            try{
                
                if(loadWheelNamesFromDB().length == Wheel.values().length){ 
                    for(String wheel:loadWheelNamesFromDB()){
                        wheels.add(Wheel.valueOf(wheel));
                    }
                }else Wheel.valueOf(null);
            }catch(IndexOutOfBoundsException e) {
                
                System.out.println("Ошибка!");
            }
            
            //init wheels here
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
        new Car();
    }
}
