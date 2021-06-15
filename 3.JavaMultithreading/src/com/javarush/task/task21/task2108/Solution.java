package com.javarush.task.task21.task2108;

/* 
Клонирование растений
*/
public class Solution {
    static String sol = "0";
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable{
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }
        
        public Tree clone() throws CloneNotSupportedException{
            
            Solution.Tree tree = new Solution.Tree(this.getName(), this.getBranches().clone());
            return tree;
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

        Tree guest = (Tree) n;
        if (this.getName().equals(guest.getName()))
			return true;
        else return false;
        }
    }
}
