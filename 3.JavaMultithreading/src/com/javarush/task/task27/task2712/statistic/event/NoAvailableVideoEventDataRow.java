package com.javarush.task.task27.task2712.statistic.event;

import java.util.*;

public class NoAvailableVideoEventDataRow implements EventDataRow{
    private Date currentDate;
    private int totalDuration; // - время приготовления заказа в секундах
    
    public NoAvailableVideoEventDataRow(int totalDuration){
        this.currentDate = new Date();
        this.totalDuration = totalDuration;
    }

    public EventType getType(){
        return EventType.NO_AVAILABLE_VIDEO;
    }

    @Override
    public Date getDate() {
        return currentDate;
    }

    @Override
    public int getTime() {
        return totalDuration;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public int getTotalDuration() {
        return totalDuration;
    }
}