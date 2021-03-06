package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FunctionalTest {


    public void testStorage(Shortener shortener){
        String str1 = "Текст1";
        String str2 = "Текст2";
        String str3 = "Текст1";
        List<Long> longList = new ArrayList<>();
        Long id1 = shortener.getId(str1);
        Long id2 = shortener.getId(str2);
        Long id3 = shortener.getId(str3);
        longList.add(id1);
        longList.add(id2);
        longList.add(id3);
        Assert.assertNotEquals(id2, id1);
        Assert.assertNotEquals(id2, id3);
        Assert.assertEquals(id1, id3);
        String str4 = shortener.getString(id1);
        String str5 = shortener.getString(id2);
        String str6 = shortener.getString(id3);
        Assert.assertEquals(str1, str4);
        Assert.assertEquals(str2, str5);
        Assert.assertEquals(str3, str6);
    }

    @Test
   public void testHashMapStorageStrategy(){
        StorageStrategy strategy = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy(){
        StorageStrategy strategy = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy(){
        StorageStrategy strategy = new FileStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy(){
        StorageStrategy strategy = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy(){
        StorageStrategy strategy = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public void  testOurHashBiMapStorageStrategy(){
        StorageStrategy strategy = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

}
