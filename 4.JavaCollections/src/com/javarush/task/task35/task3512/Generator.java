package com.javarush.task.task35.task3512;

public class Generator<T> {
    private Class<T> cl;
    
    public Generator(Class<T> clazz){
        this.cl = clazz;
    }
    
    T newInstance () throws InstantiationException, IllegalAccessException {
        
        T t = (T) cl.newInstance();
        return t;
    }
}
