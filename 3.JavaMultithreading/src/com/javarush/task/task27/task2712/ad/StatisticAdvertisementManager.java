package com.javarush.task.task27.task2712.ad;

import java.util.Comparator;
import java.util.*;
import java.util.stream.Collectors;

public class StatisticAdvertisementManager {

    private static StatisticAdvertisementManager instance;
    private static AdvertisementStorage storage;

    private StatisticAdvertisementManager() {
        storage = AdvertisementStorage.getInstance();
    }

    public static StatisticAdvertisementManager getInstance() {
        if (instance == null) {
            instance = new StatisticAdvertisementManager();
        }
        return instance;
    }

    public List<Advertisement> getActiveVideoSet() {
        return storage.list().stream()
                .filter(a -> a.getHits() > 0)
                .sorted((firstAdvertisement, secondAdvertisement) ->
                        firstAdvertisement.getName().compareToIgnoreCase(secondAdvertisement.getName())
                )
                .collect(Collectors.toList());
    }

    public List<Advertisement> getArchivedVideoSet() {
       
        return storage.list().stream()
                .filter(a -> a.getHits() <= 0)
                .sorted((o1, o2) ->  ((Advertisement)o1).getName().compareToIgnoreCase(((Advertisement)o2).getName()))
                .collect(Collectors.toList());
    }
}
