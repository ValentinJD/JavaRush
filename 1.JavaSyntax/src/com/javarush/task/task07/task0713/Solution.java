package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>() ;
        ArrayList<Integer> arrd3 = new ArrayList<Integer>();
        ArrayList<Integer> arrd2 = new ArrayList<Integer>();
        ArrayList<Integer> arrd3d2 = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in) );
        for (int i=0; i<20; i++){
            list.add(Integer.parseInt(reader.readLine()));
        }
        for (int i=0; i<list.size();i++){
            if (list.get(i)%3==0 && list.get(i)%2==0) {
                arrd3.add(list.get(i));
                arrd2.add(list.get(i));
            }
            else if (list.get(i)%3==0) arrd3.add(list.get(i));
            else if (list.get(i)%2==0) arrd2.add(list.get(i));
            else arrd3d2.add(list.get(i));
        }
        Solution.printList(arrd3);
        Solution.printList(arrd2);
        Solution.printList(arrd3d2);
        //напишите тут ваш код
    }

    public static void printList(ArrayList<Integer> list) {
        for (Integer x : list){
            System.out.println(x);
        }
        //напишите тут ваш код
    }
}
