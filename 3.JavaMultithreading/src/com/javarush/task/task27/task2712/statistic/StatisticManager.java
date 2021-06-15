package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class StatisticManager { //С его помощью будем регистрировать события в хранилище.
    private static StatisticManager instance = new StatisticManager();   // синглтон
    private StatisticStorage statisticStorage = new StatisticStorage();
    //private Set<Cook> cooks = new HashSet<>();
    private Map<LocalDate, Double> mapProfitInEveryDay; // Дата и заработок за день
    private Object EventDataRow;
    private Map<EventType, List<EventDataRow>> storageManager = statisticStorage.storage;
    private Map<LocalDate, List<EventDataRow>> mapCooksEveryDay; // Дата и список работы поваров в этот день
    // создаем мапу с ключом датой а значением мапа с именем повара и значением продолжительностью работы в секундах
    private Map<LocalDate, Map<String, Integer>>  mapCooksEveryDay_mapNameCookAndTimeWork = new HashMap<>();

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        return instance;
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }// Регистратор событий в хранилище

    /*public void register(Cook cook) {
        cooks.add(cook);
    }*/

    /*
     метод который из хранилища достанет
      все данные, относящиеся к отображению рекламы, и посчитает общую прибыль за каждый день.
     */
    public void calcProfitInEveryDay() {
        List<EventDataRow> eventDataRowList = storageManager.get(EventType.SELECTED_VIDEOS);

        mapProfitInEveryDay = eventDataRowList.stream()
                .collect(Collectors
                        .groupingBy(eventDataRow ->{
                           // System.out.println(eventDataRow.getDate());
                            return  (LocalDate) eventDataRow.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        } ,
                                Collectors.summingDouble(e -> ((VideoSelectedEventDataRow) e).getAmount())));

    }

    public Map<LocalDate, Double> getMapProfitInEveryDay() {
        calcProfitInEveryDay();
        return mapProfitInEveryDay;
    }

    public void calcLoadCooksEveryDay() { // загрузка (рабочее время) повара, сгруппировать по дням.
        List<EventDataRow> eventDataRowList = storageManager.get(EventType.COOKED_ORDER);
        mapCooksEveryDay = eventDataRowList.stream()
                .collect(Collectors
                        .groupingBy(eventDataRow ->
                                        (LocalDate) eventDataRow.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
                        ));

        //Comparator<String> comparator = String::compareTo; // для сортировки поваров по имени

        for (Map.Entry<LocalDate, List<EventDataRow>> pair: mapCooksEveryDay.entrySet() ){
            LocalDate date = pair.getKey(); // дата
            List<EventDataRow> listEventDataRow = pair.getValue(); //

            Map<String, Integer> mapCooksLoadEveryDay = listEventDataRow.stream()
                    .collect(Collectors
                            .groupingBy(
                                    eventDataRow -> ((CookedOrderEventDataRow) eventDataRow).getCookName(),
                                    Collectors.summingInt(
                                             e -> ((CookedOrderEventDataRow)e).getTime()
                                    )
                            )
                    );

            Map<String, Integer> sortedMap = new TreeMap<>();
            sortedMap.putAll(mapCooksLoadEveryDay); // создаем отсортированную мап в убышвающем порядке даты

            mapCooksEveryDay_mapNameCookAndTimeWork.put(date, mapCooksLoadEveryDay);
        }
    }

    public Map<LocalDate, Map<String, Integer>> getMapLoadCooksEveryDay(){
        calcLoadCooksEveryDay();
        return mapCooksEveryDay_mapNameCookAndTimeWork;
    }

    private static class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage; // Храним тип события список событий

        public StatisticStorage() {
            storage = new HashMap<>();
            for (EventType eventType : EventType.values()) {
                storage.put(eventType, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            storage.get(data.getType())
                    .add(data); // добавляет поле data типа EventDataRow согласно одному из трех EventDataRow
        }
    }

    /*public Set<Cook> getCooks() {
        return cooks;
    }*/
}