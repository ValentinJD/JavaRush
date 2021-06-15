package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

public class Provider {
    private Strategy strategy;

    public Provider(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<Vacancy> getJavaVacancies(String searchString) {
        try {
            return strategy.getVacancies(searchString);
        } catch (NullPointerException e) {
            return new ArrayList<>();
        }

    }
}
//https://hh.ua/search/vacancy?area=115&clusters=true&enable_snippets=true&text=java&page=1