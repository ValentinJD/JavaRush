package com.javarush.task.task33.task3310.strategy;

import java.nio.file.Path;

public class FileStorageStrategy implements StorageStrategy {
    private static final int DEFAULT_INITIAL_CAPACITY = 16; // количество бакетов
    private static final long DEFAULT_BUCKET_SIZE_LIMIT = 1000; // максимальный размер файла loadFactor
    private FileBucket[] table;
    private int size;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;// параметр для увеличения размера массива
    // аналог threshold
    long maxBucketSize;

    public FileStorageStrategy() {
        table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
        for (int i = 0; i < table.length; ++i)
            table[i] = new FileBucket();
    }


    public int hash(Long k) {
        k ^= (k >>> 20) ^ (k >>> 12);
        return (int) (k ^ (k >>> 7) ^ (k >>> 4));
    }

    public int indexFor(int hash, int length) { // индекс корзины для получения элемента
        return hash & (length - 1);
    }

    // изменение размера нашей таблицы в том случае если она еще не доросла до MAXIMUM_CAPACITY

    public void resize(int newCapacity) {
        FileBucket[] newTable = new FileBucket[newCapacity];

        for (int i = 0; i < newTable.length; i++)
            newTable[i] = new FileBucket();

        transfer(newTable);
        table = newTable;
    }

    public void transfer(FileBucket[] newTable) { // перераспределение элементов
        int newCapacity = newTable.length;

        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) continue;
            Entry entry = table[i].getEntry();

            while (entry != null) {
                Entry next = entry.next;
                int indexFor = indexFor(entry.hash, newCapacity);
                entry.next = newTable[indexFor].getEntry();
                newTable[indexFor].putEntry(entry);
                entry = next;
            }

            table[i].remove();
            table[i] = null;
        }
    }

    public void addEntry(int hash, Long key, String value, int bucketIndex) {
        Entry e = table[bucketIndex].getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, e));
        if (table[bucketIndex].getFileSize() > bucketSizeLimit) {
            resize(2 * table.length);
            size++;
        }
    }

    public void createEntry(int hash, Long key, String value, int bucketIndex) {
        table[bucketIndex] = new FileBucket();
        table[bucketIndex].putEntry(new Entry(hash, key, value, null));
        size++;
    }

    public Entry getEntry(Long key) {
        int hash = (key == null) ? 0 : hash(key);
        for (Entry e = table[indexFor(hash, table.length)].getEntry(); e != null; e = e.next) {
            Long k;
            if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k))))
                return e;
        }

        return null;
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        return getKey(value) != null;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(key);
        int i = indexFor(hash, table.length);

        if (table[i] == null)
            createEntry(hash, key, value, i);
        else {
            for (Entry entry = table[i].getEntry(); entry != null; entry = entry.next) {
                Long k;
                if (entry.hash == hash && ((k = entry.key) == key || key.equals(k)))
                    entry.value = value;
            }
            addEntry(hash, key, value, i);
        }
    }

    @Override
    public Long getKey(String value) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) continue;
            for (Entry e = table[i].getEntry(); e != null; e = e.next)
                if (value.equals(e.value))
                    return e.key;
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        if (getEntry(key) == null) return null;
        return getEntry(key).getValue();
    }
}
