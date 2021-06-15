package com.javarush.task.task27.task2712.ad;

import java.util.List;

public class Advertisement { // рекламное объявление
    private Object content; // видео
    private String name; //имя/название
    private long initialAmount;
    //начальная сумма, стоимость рекламы в копейках. Используем long, чтобы избежать проблем с округлением
    private int hits; // количество оплаченных показов
    private  int duration; //продолжительность в секундах
    private long amountPerOneDisplaying; // стоимость просмотра ролика


    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        if (hits > 0)
        this.amountPerOneDisplaying = initialAmount / hits;
        //else  this.amountPerOneDisplaying = 0;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public void revalidate() throws UnsupportedOperationException{ //если количество показов не положительное число

        if (hits < 1){
            throw new UnsupportedOperationException();
        }else hits--;
    }

    @Override
    public String toString() {
        //First Video is displaying... 50, 277
        return name + " is displaying... "+  amountPerOneDisplaying + ", " + (int) ((double)amountPerOneDisplaying* 1000d/(double)duration );
    }

    public int getHits() {
        return hits;
    }
}
