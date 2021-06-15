package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {
    //Он должен возвращать время в миллисекундах необходимое для получения идентификаторов для всех строк из strings.
    // Идентификаторы должны быть записаны в ids.
    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids){
        Date date = new Date();
        for (String str : strings){
            ids.add(shortener.getId(str));
        }
        Date date1 = new Date();
        return date1.getTime() - date.getTime();
    }


    //Он должен возвращать время
    // в миллисекундах необходимое для получения строк для всех идентификаторов из ids. Строки должны быть записаны в strings.
    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        Date date = new Date();
        for (Long id : ids){
            strings.add(shortener.getString(id));
        }
        Date date1 = new Date();
        return date1.getTime() - date.getTime();
    }

    @Test
    public void testHashMapStorage(){
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i < 10000; i++){
            origStrings.add(Helper.generateRandomString());
        }
        Set<Long> origIds = new HashSet<>();
        for (String s: origStrings){
            origIds.add(shortener1.getId(s));
        }
        Long speed = getTimeToGetIds(shortener1, origStrings, origIds);
        Long speed2 = getTimeToGetIds(shortener2, origStrings, origIds);
        Assert.assertTrue(speed > speed2);

        Long speed3 = getTimeToGetStrings(shortener1, origIds, origStrings);
        Long speed4 = getTimeToGetStrings(shortener2, origIds, origStrings);
        Assert.assertEquals(speed3, speed4, 30);
    }





}
