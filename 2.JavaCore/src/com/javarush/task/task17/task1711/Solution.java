package com.javarush.task.task17.task1711;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }
    
    
    public volatile static String[] args1;

    public static void main(String[] args) {
        args1 = args;
        switch(args[0]){
            case "-c":
                synchronized(allPeople){
                    create();
                break;
                }
            case "-u":
                synchronized(allPeople){
                update();
                break;
                }
            case "-d":
                synchronized(allPeople){
                delete();
                break;
                }
            case "-i":
                synchronized(allPeople){
                info();
                break;
                }
        }
        //start here - начни тут
    }
    
    public static void create(){
        
          for(int i=1; i<args1.length; i=i+3){
            String name = args1[i];
            String sex = args1[i+1];
            String bd = args1[i+2];
            Date date = null;
            try{
            date=new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(bd);
            }catch(ParseException e){
            e.printStackTrace();
            }
            if(sex.equals("м")){
                Person person = Person.createMale(name, date);
                person.setSex(Sex.MALE);
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
            }else if(sex.equals("ж")){
                Person person = Person.createFemale(name, date);
                person.setSex(Sex.FEMALE);
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
            }
            
          }
    }
    
    public static void update(){
        
        for(int i=1; i<args1.length; i=i+4){
            int id = Integer.parseInt(args1[i]);
            String name = args1[i+1];
            String sex = args1[i+2];
            String bd = args1[i+3];
            Date date = null;
            
            Person person = allPeople.get(id);
            person.setName(name);
            if(sex.equals("м")){ person.setSex(Sex.MALE);
            } else person.setSex(Sex.FEMALE);
            try{
                date=new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(bd);
            }catch(ParseException e){}
            person.setBirthDate(date);
        }
        
    }
    
    public static void delete(){
        
        for(int i=1; i<args1.length; i++){
            int id = Integer.parseInt(args1[i]);
            Person person = allPeople.get(id);
            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);
        }
    }
    
    public static void info(){
        
        for(int i=1; i<args1.length; i++){
            int id = Integer.parseInt(args1[i]); 
            Person person = allPeople.get(id); 
            SimpleDateFormat dateformat=new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            System.out.println(String.format("%s %s %s", person.getName(), person.getSex() == Sex.MALE ? "м" : "ж", dateformat.format(person.getBirthDate())));
            
        }
    }
}
