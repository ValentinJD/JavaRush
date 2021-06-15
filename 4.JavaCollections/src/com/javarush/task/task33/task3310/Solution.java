package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        StorageStrategy strategy = new HashMapStorageStrategy();
        testStrategy(strategy, 10000);

        StorageStrategy strategy1 = new OurHashMapStorageStrategy();
        testStrategy(strategy1, 10000);

        StorageStrategy strategy2 = new FileStorageStrategy();
        testStrategy(strategy2, 100);

        StorageStrategy strategy3 = new OurHashBiMapStorageStrategy();
        testStrategy(strategy3, 10000);

        StorageStrategy strategy4 = new HashBiMapStorageStrategy();
        testStrategy(strategy4, 10000);

        StorageStrategy strategy5 = new DualHashBidiMapStorageStrategy();
        testStrategy(strategy5, 10000);

    }

    //Этот метод должен для переданного множества строк возвращать множество идентификаторов.
    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> set = new HashSet<>();
        for (String value: strings){
            set.add(shortener.getId(value));
        }
        return set;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> set = new HashSet<>();
        for (Long key: keys){
            set.add(shortener.getString(key));
        }
        return set;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){

        Helper.printMessage(strategy.getClass().getSimpleName());

        Set<String> stringSet = new HashSet<>();
        for (long i = 0; i < elementsNumber; i++ ){
            stringSet.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);

        Date date = new Date();

        Set<Long> setIds = getIds(shortener, stringSet);

        Date date1 = new Date();

        Helper.printMessage((date1.getTime() - date.getTime()) + "");

        Date date2 = new Date();

        Set<String> setStrings = getStrings(shortener,setIds);

        Date date3 = new Date();

        Helper.printMessage((date3.getTime() - date2.getTime()) + "");
        
        if (stringSet.size() == setStrings.size()){
            Helper.printMessage("Тест пройден.");
        }else {
            Helper.printMessage("Тест не пройден.");
        }
    }

}
