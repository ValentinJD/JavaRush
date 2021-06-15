package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        try {
            String arg1 = args[0];
            String arg = arg1.toUpperCase();
            int len = arg.length();
            Pattern pattern = Pattern.compile("([A-Z]|[0-9]){" + len + "}");
            Matcher matcher = pattern.matcher(arg);
            if (!matcher.find()){
                System.out.println("incorrect");
            }else{
              int min = arg.charAt(0);
             
              for(int i = 0; i < len; i++){
                if(arg.charAt(i) > min ){
                  min = arg.charAt(i);
                }
              }              

              if(min == 48 || min == 49){ // 0 1
                     min = 2;

              }else if(min > 49 && min < 58){ //2-9
                min = min - 47;
              }else {
                min = min -54;
              }

               System.out.println(min);
                           
            }  

            
        }catch (Exception e){

        }





        //напишите тут ваш код
    }
}