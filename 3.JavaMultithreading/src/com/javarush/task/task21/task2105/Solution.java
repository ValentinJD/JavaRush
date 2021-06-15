package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }
    @Override
    public boolean equals(Object o) {
        if (this == null) return false;
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;
        Solution sol = (Solution) o;
        if ((this.first==null)&&(sol.first==null)&&(this.last==null)&&(sol.last==null)) return true;
        if (((this.first==null)&&(sol.first!=null))||((this.last==null)&&(sol.last!=null))||
        ((this.first!=null)&&(sol.first==null))||((this.last!=null)&&(sol.last==null))) return false;
        if ((this.first==null)&&(sol.first==null)) return this.last.equals(sol.last);
        if ((this.last==null)&&(sol.last==null)) return this.first.equals(sol.first);
        return sol.first.equals(first) && sol.last.equals(last);
    }
    @Override
    public int hashCode() {
        if(this.first == null || this.last == null) return 0;
        return Objects.hash(first, last);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
