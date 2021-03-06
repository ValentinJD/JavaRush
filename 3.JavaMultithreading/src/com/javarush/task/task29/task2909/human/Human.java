package com.javarush.task.task29.task2909.human;                                                                                                    
                                                                                                    
import java.util.ArrayList;                                                                                                    
import java.util.Collections;                                                                                                    
import java.util.List;                                                                                                    
                                                                                                    
public class Human implements Alive {                                                                                                    
    private static int nextId = 0;                                                                                                    
    private int id;                                                                                                    
    protected int age;                                                                                                    
    protected String name;                                                                                                    
                                                                                                    
    private List<Human> children = new ArrayList<>();                                                                                                    
                                                                                                    
    private BloodGroup bloodGroup;                                                                                                    
                                                                                                    
    public void setBloodGroup(BloodGroup code) {                                                                                                    
        this.bloodGroup = code;                                                                                                    
    }                                                                                                    
                                                                                                    
    public BloodGroup getBloodGroup() {                                                                                                    
        return bloodGroup;                                                                                                    
    }                                                                                                    
                                                                                                        
    public void printData() {                                                                                                    
        System.out.println(getPosition() + ": " + name);                                                                                                    
    }                                                                                                    
                                                                                                    
    public String getPosition(){                                                                                                    
        return "??????????????";                                                                                                    
    }                                                                                                    
                                                                                                    
    public Human(String name, int age) {                                                                                                    
        this.age = age;                                                                                                    
        this.name = name;                                                                                                    
        this.id = nextId;                                                                                                    
        nextId++;                                                                                                    
    }                                                                                                    
                                                                                                    
    public int getAge() {                                                                                                    
        return age;                                                                                                    
    }                                                                                                    
                                                                                                    
    public String getName() {                                                                                                    
        return name;                                                                                                    
    }                                                                                                    
                                                                                                    
                                                                                                    
    public List<Human> getChildren() {                                                                                                    
        return Collections.unmodifiableList(children);                                                                                                    
    }                                                                                                    
                                                                                                    
    public void addChild (Human human) {                                                                                                    
        children.add(human);                                                                                                    
    }                                                                                                    
                                                                                                    
    public void removeChild (Human human){                                                                                                    
        children.remove(human);                                                                                                    
    }                                                                                                    
                                                                                                    
    public void live() {                                                                                                    
                                                                                                    
    }                                                                                                    
                                                                                                    
    public int getId() {                                                                                                    
        return id;                                                                                                    
    }                                                                                                    
                                                                                                        
    private Size size;                                                                                                    
                                                                                                    
    public class Size {                                                                                                    
        public int height;                                                                                                    
        public int weight;                                                                                                    
    }                                                                                                    
                                                                                                    
    public void printSize() {                                                                                                    
        System.out.println("????????: " + size.height + " ??????: " + size.weight);                                                                                                    
    }                                                                                                    
}