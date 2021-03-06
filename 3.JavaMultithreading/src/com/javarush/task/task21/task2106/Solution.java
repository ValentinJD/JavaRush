package com.javarush.task.task21.task2106;

import java.util.Date;
import java.util.Objects;

/* 
Ошибка в equals/hashCode
*/
public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this == null) return false;
        if (!(o instanceof Solution)) return false;

        Solution solution1 = (Solution) o;
        
        if(!Objects.equals(solution1.aDouble, aDouble))return false;
        if(!Objects.equals(solution1.anInt, anInt))return false;
        if(!Objects.equals(solution1.date, date))return false;
        if(!Objects.equals(solution1.solution, solution))return false;
        if(!Objects.equals(solution1.string, string))return false;

        //if (Double.compare(solution1.aDouble, aDouble) != 0) return false;
        //if (anInt != solution1.anInt) return false;
        //if (date != null ? !date.equals(solution1.date) : solution1.date == null) return false;
        //if (solution != null ? !solution.equals(solution1.solution) : solution1.solution == null) return false;
        //if (string != null ? !string.equals(solution1.string) : solution1.string == null) return false;
        

        return true;
    }

    @Override
    public int hashCode() {
        if (string == null || date == null || solution == null) return 0;
        return Objects.hash(anInt, string, aDouble, date, solution);
        /*int result;
        long temp;
        result = anInt;
        temp = aDouble != +0.0d ? Double.doubleToLongBits(aDouble) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (solution != null ? solution.hashCode() : 0);
        return result;*/
    }

    public static void main(String[] args) {

    }
}
