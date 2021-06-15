package com.javarush.task.task29.task2909.car;                                                                                                    
                                                                                                    
import java.util.Date;                                                                                                    
                                                                                                    
public abstract class Car {
    static public final int TRUCK = 0;                                                                                                    
    static public final int SEDAN = 1;                                                                                                    
    static public final int CABRIOLET = 2;                                                                                                    
                                                                                                    
    double fuel;                                                                                                    
                                                                                                    
    public double summerFuelConsumption;                                                                                                    
    public double winterFuelConsumption;                                                                                                    
    public double winterWarmingUp;                                                                                                    
                                                                                                    
    private int type;                                                                                                    
                                                                                                    
    private boolean driverAvailable;                                                                                                    
    private int numberOfPassengers;                                                                                                    
                                                                                                    
    protected Car(int type, int numberOfPassengers) {                                                                                                    
        this.type = type;                                                                                                    
        this.numberOfPassengers = numberOfPassengers;                                                                                                    
    }                                                                                                    
                                                                                                        
    public static Car create(int type, int numberOfPassengers){                                                                                                    
        if(type == 0) return new Truck(numberOfPassengers);                                                                                                    
        else if(type == 1) return new Sedan(numberOfPassengers);                                                                                                    
        else return new Cabriolet(numberOfPassengers);                                                                                                    
    }                                                                                                    
                                                                                                    
    public void fill(double numberOfLiters) throws Exception{
        if (numberOfLiters < 0) {
            throw new Exception ();
        }                                                  
        fuel += numberOfLiters;
    }                                                                                                    
                                                                                                    
    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {                                                                                                    
        double consumption;                                                                                                    
        if (isSummer(date, SummerStart, SummerEnd)) {
            consumption = getSummerConsumption(length);
        } else {                                                                                                    
            consumption = getWinterConsumption(length);

        }                                                                                                    
        return consumption;                                                                                                    
    }

    public boolean isSummer(Date date, Date SummerStart, Date SummerEnd){
        if (date.after(SummerStart) && date.before(SummerEnd)) {
           return true;
        } else return false;
    }

    public double getWinterConsumption(int length){
        double consumption = length * winterFuelConsumption + winterWarmingUp;
        return consumption;
    }

    public double getSummerConsumption(int length){
        double consumption = length * summerFuelConsumption;
        return consumption;
    }
                                                                                                    
    public int getNumberOfPassengersCanBeTransferred() {
       if(canPassengersBeTransferred())
        return numberOfPassengers;
       else return 0;
    }                                                                                                    
                                                                                                    
    public boolean isDriverAvailable() {                                                                                                    
        return driverAvailable;                                                                                                    
    }                                                                                                    
                                                                                                    
    public void setDriverAvailable(boolean driverAvailable) {                                                                                                    
        this.driverAvailable = driverAvailable;                                                                                                    
    }                                                                                                    
                                                                                                    
    public void startMoving() {                                                                                                    
        if (numberOfPassengers > 0) {                                                                                                    
            fastenPassengersBelts();
        }
        fastenDriverBelt();
    }                                                                                                    
                                                                                                    
    public void fastenPassengersBelts() {                                                                                                    
    }                                                                                                    
                                                                                                    
    public void fastenDriverBelt() {                                                                                                    
    }

    abstract public  int getMaxSpeed() ;

   private boolean canPassengersBeTransferred(){
        return (isDriverAvailable() && fuel>0);
    }
}