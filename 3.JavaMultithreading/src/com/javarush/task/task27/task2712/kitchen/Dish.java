package com.javarush.task.task27.task2712.kitchen;


public enum Dish {
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);
    //Fish, Steak, Soup, Juice, Water;

    private int duration;

    Dish(int i) {
        this.duration = i;
    }

    public int getDuration() {
        return duration;
    }

    private static Dish[] dishes = Dish.values();
    
    public static String allDishesToString(){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i < dishes.length; i++){
            if(i != (dishes.length-1)){
                stringBuffer.append(dishes[i] + ", ");
            }
        }
        stringBuffer.append(dishes[dishes.length-1]);
        
        return stringBuffer.toString();
    }
}