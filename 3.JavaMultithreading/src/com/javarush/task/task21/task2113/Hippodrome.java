package com.javarush.task.task21.task2113;

import java.util.*;

public class Hippodrome {
    private List<Horse> horses; 
    
    public static Hippodrome game;
    
    public Hippodrome(List<Horse> horses){
       this.horses = horses;
    }
    
    public List<Horse> getHorses(){
        return horses;
    }
    
    public static void main (String[] args) throws InterruptedException{
        Horse zorka = new Horse("Зорька", 3, 0);
        Horse murka = new Horse("Мурка", 3, 0);
        Horse murenka = new Horse("Муренка", 3, 0);
        
        game = new Hippodrome(new ArrayList());
        
        game.getHorses().add(zorka);
        game.getHorses().add(murka);
        game.getHorses().add(murenka);
        
        game.run();
        game.printWinner();
        
    }
    
    public void run() throws InterruptedException{
        for(int i=0; i<100; i++){
            move();
            print();
            Thread.sleep(200);
        }
        
    }
    
    public void move(){
        for(Horse horse: horses){
            horse.move();
        }
    }
    
    public void print(){
        for(Horse horse: horses){
            horse.print();
        }
        
        for(int i=0; i<10; i++) System.out.println();
    }
    
    public Horse getWinner(){
        double maxDistance = 0;
        Horse winner = null;
        for(Horse horse: horses){
            double distance = horse.getDistance();
            if(distance>maxDistance){
                winner = horse;
                maxDistance = distance;
            }
        }
        return winner;
    }
    
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
    
    
}