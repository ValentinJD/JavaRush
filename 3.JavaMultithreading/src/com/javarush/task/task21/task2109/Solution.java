package com.javarush.task.task21.task2109;

import java.util.Objects;

/*
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof A)) return false;
            A a = (A) o;
            return getI() == a.getI() &&
                    getJ() == a.getJ();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getI(), getJ());
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        public B(){
            super(1, 2);
        }

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }
        @Override
        protected B clone() throws CloneNotSupportedException {
            throw new  CloneNotSupportedException();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof B)) return false;
            if (!super.equals(o)) return false;
            B b = (B) o;
            return getName().equals(b.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), getName());
        }

        public String getName() {
            return name;
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        public C() {

        }

        @Override
        protected C clone() throws CloneNotSupportedException{

            return new C();
        }


    }

    public static void main(String[] args) throws CloneNotSupportedException {
        C c = new C();
        C c1 = c.clone();
        System.out.println(c);
        System.out.println(c1);

        B b = new B();
        B b1 = b.clone();

    }
}
