package com.javarush.task.task27.task2712.statistic.event;

import java.util.*;
import com.javarush.task.task27.task2712.kitchen.*;


public class CookedOrderEventDataRow implements EventDataRow{
    private Date currentDate;
    private String tabletName; //Name - имя планшета
    private String cookName; // - имя повара
    private int cookingTimeSeconds; // - время приготовления заказа в секундах
    private List<Dish> cookingDishs; // - список блюд для приготовления
    
    public CookedOrderEventDataRow(String tabletName, String cookName, int cookingTimeSeconds, List<Dish> cookingDishs){
        this.currentDate = new Date();
        this.tabletName = tabletName;
        this.cookName = cookName;
        this.cookingTimeSeconds = cookingTimeSeconds; 
        this.cookingDishs = cookingDishs;
    }

    public EventType getType(){
        return EventType.COOKED_ORDER;
    }

    @Override
    public Date getDate() {
        return currentDate;
    }

    @Override
    public int getTime() {
        return cookingTimeSeconds;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public String getTabletName() {
        return tabletName;
    }

    public String getCookName() {
        return cookName;
    }

    public int getCookingTimeSeconds() {
        return cookingTimeSeconds;
    }

    public List<Dish> getCookingDishs() {
        return cookingDishs;
    }
}