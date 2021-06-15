package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage { // хранилище рекламных роликов
    private static AdvertisementStorage instance;   // синглтон
    private static final List<Advertisement> videos = new ArrayList<>();

    private AdvertisementStorage() {
        
        Object someContent = new Object();
        add(new Advertisement(someContent, "1 Video", 5000, 100, 3 * 60)); // 3 min
        add(new Advertisement(someContent, "2 Video", 100, 10, 15 * 60)); //15 min
        add(new Advertisement(someContent, "3 Video", 400, 10, 10 * 60));//10 min
        add(new Advertisement(someContent, "4 Video", 600, 10, 9 * 60));
        add(new Advertisement(someContent, "5 Video", 900, 0, 8 * 60));
        add(new Advertisement(someContent, "6 Video", 450, 0, 7 * 60));
        add(new Advertisement(someContent, "7 Video", 450, 10, 6 * 60));
        add(new Advertisement(someContent, "8 Video", 400, 10, 5 * 60));
        //System.out.println("конструктор в AdvertisementStorage= " + videos.size());

    }

    public static AdvertisementStorage getInstance() {
        if (instance == null)
            instance = new AdvertisementStorage();
            //System.out.println("getInstance в AdvertisementStorage= " + videos.size());
        return instance;
    }

    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }

    public List<Advertisement> list() {
        //System.out.println("метод лист в AdvertisementStorage= " + videos.size());
        return videos;
    }
}
