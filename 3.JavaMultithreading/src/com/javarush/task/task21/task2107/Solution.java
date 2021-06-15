package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.*;
import java.lang.*;


/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable {
    String sol = "0";

    public static void main(String[] args)  {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
        
        @Override
        public User clone() throws CloneNotSupportedException{
            Solution.User use = new Solution.User(this.age, this.name );
            return use;
        }
        
        @Override
        public int hashCode() {
            if(name == null) return 0;
        return 31 * name.hashCode();
    }
    }
    @Override
    public Solution clone() throws CloneNotSupportedException{
        Solution clon = new Solution();
        clon.users = Collections.synchronizedMap(this.users);
        //Map<String, User> copiedMap = Collections.synchronizedMap(this.users);
        /*for(Map.Entry <String, User> pair: this.users.entrySet()){
            Solution.User currentUser = pair.getValue();
            String nameUser = pair.getKey();
            clon.users.put(nameUser, currentUser.clone());
        }*/
        return clon;
        
    }
    
    @Override
    public int hashCode() {
        if(sol == null) return 0;
        return 31 * sol.hashCode();
    }
    
    @Override
    public boolean equals(Object n) {
        if (n == this) { return true; }
        if (n == null && this == null) { return true; }
        if (n instanceof Solution) return true;

        Solution guest = (Solution) n;
        if (this.users.equals(guest.users))
			return true;
        else return false;
		
    }
}
