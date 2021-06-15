package com.javarush.task.task27.task2712.statistic.event;


import java.util.Date;

public interface EventDataRow { // На данный момент он является интерфейсом-маркером, т.к. не содержит методов,
    //и по нему мы определяем, является ли переданный объект событием или нет.
    EventType getType();

    Date getDate();

    int getTime();
}