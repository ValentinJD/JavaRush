package com.javarush.task.task27.task2712.statistic.event;

import java.util.*;
import com.javarush.task.task27.task2712.ad.*;

public class VideoSelectedEventDataRow implements EventDataRow{
    private Date currentDate;
    private List<Advertisement> optimalVideoSet; //- список видео-роликов, отобранных для показа
    private long amount; // - сумма денег в копейках
    private int totalDuration; // - общая продолжительность показа отобранных рекламных роликов
    
    public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration){
        this.currentDate = new Date();
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
    }

    public EventType getType(){
        return EventType.SELECTED_VIDEOS;
    }

    @Override
    public Date getDate() {
        return currentDate;
    }

    @Override
    public int getTime() {
        return totalDuration;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public List<Advertisement> getOptimalVideoSet() {
        return optimalVideoSet;
    }

    public long getAmount() {
        return amount;
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
}