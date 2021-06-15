package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandfotherName = reader.readLine();
        Cat grandfother = new Cat(grandfotherName);

        String grandmotherName = reader.readLine();
        Cat grandmother = new Cat(grandmotherName);

        String fotherName = reader.readLine();
        Cat catFother = new Cat(fotherName, grandfother);
        catFother.grandfather = grandfother;

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, grandmother);
        catMother.grandmother = grandmother;

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catFother, catMother);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catFother, catMother);

        System.out.println(grandfother);
        System.out.println(grandmother);
        System.out.println(catFother);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat parent;
        private Cat parentm;
        private Cat parentw;
        private Cat grandfather;
        private Cat grandmother;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat parent) {
            this.name = name;
            this.parent = parent;
        }

        Cat(String name, Cat parentm, Cat parentw) {
            this.name = name;
            this.parentm = parentm;
            this.parentw = parentw;
        }


        @Override
        public String toString() {
            if (parent == null && parentm == null)
                return "The cat's name is " + name + ", no mother " + ", no father";
            else if (parentm == null && parentw == null && grandfather != null)
                return "The cat's name is " + name + ", no mother, father is " + parent.name;
            else if (parentm == null && parentw == null)
                return "The cat's name is " + name + ", mother is " + parent.name + ", no father";
            else
                return "The cat's name is " + name + ", mother is " + parentw.name + ", father is " + parentm.name;

        }
    }

}
