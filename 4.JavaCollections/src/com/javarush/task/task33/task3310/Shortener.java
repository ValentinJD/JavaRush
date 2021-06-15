package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.StorageStrategy;

public class Shortener {
    private Long lastId = 0l; // Это поле будет
    //отвечать за последнее значение идентификатора, которое было использовано при добавлении новой строки в хранилище.
    private StorageStrategy storageStrategy;

    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    public synchronized Long getId(String value) { // будет возвращать идентификатор id для заданной строки.
        boolean valueIsPresent = storageStrategy.containsValue(value);
        if (valueIsPresent) {
            return storageStrategy.getKey(value);
        } else {
            lastId++;
            storageStrategy.put(lastId, value);
        }

        return lastId;
    }

    public synchronized String getString(Long id) { //будет возвращать строку для заданного
        // идентификатора или null, если передан неверный идентификатор.
        return storageStrategy.getValue(id);
    }
}
