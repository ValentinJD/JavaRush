package com.javarush.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.get(key);
        if(cacheMap.containsKey(key)) return softReference.get();
        else return null;

        //напишите тут ваш код
    }

    public AnyObject put(Long key, AnyObject value) {
        SoftReference<AnyObject> doSoftReference = cacheMap.get(key);
        
        if(doSoftReference == null){//если ранее по ключу значения не было
            cacheMap.put(key, new SoftReference<>(value));//добавляем
            return null;
        }else{
           AnyObject doValue = doSoftReference.get();
           doSoftReference.clear();
           cacheMap.put(key, new SoftReference<>(value));//добавляем
           return doValue;
        }
        //напишите тут ваш код
    }

    public AnyObject remove(Long key) {
        
        if(!cacheMap.containsKey(key)){//если ранее по ключу значения не было
            return null;
        }else{
           SoftReference<AnyObject> softReference = cacheMap.get(key);
           AnyObject doValue = softReference.get();
           softReference.clear();
           return doValue;
        }
        
        //напишите тут ваш код
    }
}