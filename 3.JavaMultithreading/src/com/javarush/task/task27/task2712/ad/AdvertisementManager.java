package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.*;

public class AdvertisementManager {// менеджер показа роликов
    public final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds; // время показа ролика в секундах
    private double bestTime; // время показа лучшего набора видео
    private List<Advertisement> bestListVideos;
    private long bestPrice; // стоимость показа лучшего набора роликов

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException {
        
        createAllOtionList(storage.list());
        
        if (bestListVideos == null ) throw new NoVideoAvailableException();
        Comparator<Advertisement> comparator = new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                if (o1.getAmountPerOneDisplaying() < o2.getAmountPerOneDisplaying()){
                    return 1;
                }
                if (o1.getAmountPerOneDisplaying() > o2.getAmountPerOneDisplaying()){
                    return -1;
                }
                if (o1.getAmountPerOneDisplaying() == o2.getAmountPerOneDisplaying()){
                    long o1AmountInMiliThousand = o1.getAmountPerOneDisplaying()/o1.getDuration();
                    long o2AmountInMiliThousand = o2.getAmountPerOneDisplaying()/o2.getDuration();
                    if (o1AmountInMiliThousand > o2AmountInMiliThousand){
                        return 1;
                    }else if(o1AmountInMiliThousand < o2AmountInMiliThousand){
                        return -1;
                    }
                }
                return 0;
            }
        };
        
        Collections.sort(bestListVideos, comparator );
        
        Iterator iterator = bestListVideos.iterator();
        
        /*while(iterator.hasNext()){ // Удаляем ролики с показом меньше 1
            Advertisement advertisements = (Advertisement) iterator.next();
            if(advertisements.getHits() < 1) iterator.remove();
        }*/

        StatisticManager statisticManager = StatisticManager.getInstance();
        statisticManager.register(new VideoSelectedEventDataRow(bestListVideos, bestPrice, (int) bestTime ));
        
        for(Advertisement advertisements: bestListVideos){
            ConsoleHelper.writeMessage(advertisements.toString());
            advertisements.revalidate();
        }
    }

    //вычисляет общее время показа подборки роликов
    private long calcAllTimeViewVideos(List<Advertisement> list){
        long allTimeViewVideos = 0;
        for(Advertisement advertisements: list){
            if(advertisements.getHits() > 0)
            allTimeViewVideos +=advertisements.getDuration();
        }
        return allTimeViewVideos;
    }

    // вычисляет общую стоимость показа роликов
    private long calcAllPriceViewVideos(List<Advertisement> list){
        long allPriceViewVideos = 0;
        for(Advertisement advertisements: list){
            if(advertisements.getHits() > 0)
            allPriceViewVideos +=advertisements.getAmountPerOneDisplaying();
        }
        //System.out.println("стоимость видео" + allPriceViewVideos);
        //System.out.println("лучшая стоимость видео" + bestPrice);
        return allPriceViewVideos;
    }
    
    // проверяет является ли набор лучшим если да присваивает его ссылке
    private void checkVideoListOnABest(List<Advertisement> list){
        long currentPrice = calcAllPriceViewVideos(list);
        long currentTime = calcAllTimeViewVideos(list);
        if(currentTime <= timeSeconds){ // проверяем время воспроизведения текущего ролика
          if (bestListVideos == null){
              listIsBest(list, currentPrice, currentTime);
          }else {
            if ((currentPrice > bestPrice) ){
                listIsBest(list, currentPrice, currentTime);
            }else if ((currentPrice == bestPrice && currentTime > bestTime)  ){
                listIsBest(list, currentPrice, currentTime);
            }else if ((currentPrice == bestPrice && currentTime == bestTime 
                                                 && list.size() < bestListVideos.size())){
                listIsBest(list, currentPrice, currentTime);
            }
          }
        }
    }
    
    private void listIsBest(List<Advertisement> list, long currentPrice, long currentTime){
        bestListVideos = list;
        bestTime = currentTime;
        bestPrice = currentPrice;
    }
    
    // рекурсия создание всех вариантов роликов
    public void createAllOtionList(List<Advertisement> list){
        
        if (list == null || list.size() == 0)return;
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            Advertisement ad = (Advertisement) iterator.next();
           /* if(ad.getHits() < 1){
                iterator.remove();
            }*/
        }
        
        
            checkVideoListOnABest(list);

        for (int i=0; i < list.size(); i++){

            List<Advertisement> newList = new ArrayList<>(list);
            newList.remove(i);
            createAllOtionList(newList);
        }
    }
}
