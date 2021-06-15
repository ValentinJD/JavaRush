package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class DirectorTablet {
    private SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public Date convertToDate(LocalDate dateToConvert) {
        return Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    public void printAdvertisementProfit() { // 1. какую сумму заработали на рекламе, сгруппировать по дням;
        //System.out.println("1. какую сумму заработали на рекламе, сгруппировать по дням");
        StatisticManager statisticManager = StatisticManager.getInstance();
        Map<LocalDate, Double> map = statisticManager.getMapProfitInEveryDay();

        Comparator<LocalDate> comparator = Comparator.reverseOrder();

        Map<LocalDate, Double> sortedMap = new TreeMap<>(comparator);
        sortedMap.putAll(map); // создаем отсортированную мап в убышвающем порядке даты

        sortedMap.forEach((k, v) -> {
                    Date date = convertToDate(k);
                    if (v > 0) {
                        ConsoleHelper.writeMessage(
                                String.format("%s - %.2f", format.format(date), v / 100F)
                        );
                    }
                }
        );

        long total = 0; // сумма денег в копейках за все время

        for (Map.Entry<LocalDate, Double> pair : sortedMap.entrySet()) {
            total += pair.getValue();
        }

        ConsoleHelper.writeMessage(
                String.format("Total - %.2f", total / 100F)
        );
    }

    public void printCookWorkloading() { //2. загрузка (рабочее время) повара, сгруппировать по дням;
         // System.out.println("2. загрузка (рабочее время) повара, сгруппировать по дням;");
        StatisticManager statisticManager = StatisticManager.getInstance();
        Map<LocalDate, Map<String, Integer>> map = statisticManager.getMapLoadCooksEveryDay();

        map.forEach((data, mapName_Time) -> {

                    Date date = convertToDate(data);

                    ConsoleHelper.writeMessage(format.format(date));

                    mapName_Time.forEach((name, time) -> {
                                //Ivanov - 60 min
                                ConsoleHelper.writeMessage(
                                        String.format("%s - %.0f min", name, Math.ceil(time / 60F))
                                );
                            }
                    );

                }
        );
    }

    public void printActiveVideoSet() { // 3. список активных роликов и оставшееся количество показов по каждому;
        
        StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstance();
        List<Advertisement> videos = statisticAdvertisementManager.getActiveVideoSet();
        //System.out.println("printActiveVideoSet");
        //System.out.println("videos.size()= " + videos.size());
        videos.forEach(a ->  ConsoleHelper.writeMessage(String.format("%s - %d", a.getName(), a.getHits())));
    }

    public void printArchivedVideoSet() { // 4. список неактивных роликов (с оставшемся количеством показов равным нулю).
        //System.out.println("printArchivedVideoSet");
        StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstance();
        List<Advertisement> videos = statisticAdvertisementManager.getArchivedVideoSet();
        //System.out.println("videos.size()= " + videos.size());
        videos.forEach(a -> ConsoleHelper.writeMessage(a.getName()));
    }
}
