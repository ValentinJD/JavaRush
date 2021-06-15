package com.javarush.task.task26.task2601;

/* 
Почитать в инете про медиану выборки
*/
import java.util.Arrays;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
   /* Integer[] array = { 13, 8, 15, 5, 17 };
    //Integer[] array = { 5, 8, 13, 15  };
    System.out.println("До сортировки");
    for (Integer i : array) {
      System.out.print(i + ", " );
    }
    System.out.println();
    sort(array); // Сортируем
    System.out.println("После сортировки");
    for (Integer i : array) {
      System.out.print(i + ", " );
    }*/
  }

  public static Integer[] sort(Integer[] array) {
    Arrays.sort(array);
    Integer median1 = null;
    if (array.length % 2 != 0) { // находим медиану для нечетного количества элементов массива
      median1 = array[array.length / 2];
     // System.out.println(median1 + "медиана");
    } else {median1 = (array[array.length / 2] + array[array.length / 2 - 1])/2; // находим медиану для четного количества
        // элементов массива
       // System.out.println(median1 + "медиана");
    }
    final Integer median = median1;
    Comparator<Integer> compareByMedian = new Comparator<Integer>() {
      public int compare(Integer x, Integer y) {
        return (Math.abs(median-x)- Math.abs(median-y));
      }
    };
    List<Integer> list = Arrays.asList(array);

    Collections.sort(list, compareByMedian);
    int x =0;
    Integer[] arMedia = new Integer[array.length];
    for(Integer p:list){
      arMedia[x] = p;
      x++;
    }
    array = arMedia;
    // implement logic here
    return array;
  }

}
