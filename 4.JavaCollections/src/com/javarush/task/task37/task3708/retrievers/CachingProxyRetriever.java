package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever{
    private Storage storage;
    private OriginalRetriever originalRetriever;
    private LRUCache cache = new LRUCache(100);

    public CachingProxyRetriever(Storage storage) {
        this.storage = storage;
        originalRetriever = new OriginalRetriever(storage);

    }

    @Override
    public Object retrieve(long id) {
        if (cache.find(id) == null){
            Object o = originalRetriever.retrieve(id);
            cache.set(id, o);
        }
        return cache.find(id);
    }
}
