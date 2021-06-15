package com.javarush.task.task34.task3408;

import java.util.Map;
import java.util.*;
import java.lang.reflect.*;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<K, V>();
    //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
         if (!cache.containsKey(key)){
              Constructor constructor = clazz.getConstructor(key.getClass());
               V myObject = (V) constructor.newInstance(key);
               cache.put(key, myObject);
               return myObject;
         }
        //TODO add your code here
        return cache.get(key);
    }

    public boolean put(V obj) {
        try{
            Method getKey = obj.getClass().getDeclaredMethod("getKey", null);
            getKey.setAccessible(true);
            K key = (K) getKey.invoke(obj, null);
            cache.put(key, obj);
            return true;
        }catch(Exception e){
            return false;
        }
        //TODO add your code here
        
    }

    public int size() {
        return cache.size();
    }
}
