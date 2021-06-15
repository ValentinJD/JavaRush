package com.javarush.task.task04.task0441;

/* 
Как-то средненько
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        // 123 132 213// 231 //312// 321 // 112 122 222 //312
        if ((a==b)&&(a==c)) System.out.println(a);
           else if ((a==b)||(b==c)) System.out.println(b);
           else if ((a==c)) System.out.println(c);
           else if ((b>a)&&(b<c)) System.out.println(b);
           else if ((c>a)&&(c<b)) System.out.println(c);
           else if ((a>b)&&(a<c)) System.out.println(a);
           else if ((a<b)&&(a>c)) System.out.println(a);
           else if ((c>a)&&(c>a)) System.out.println(c);
           else if((c<a)&&(c>b)) System.out.println(c);
           else  System.out.println(b);
    }
}
