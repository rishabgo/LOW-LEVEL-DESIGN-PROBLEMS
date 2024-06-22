package org.example;

import org.example.evictionPolicy.EvictionPolicy;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public final class CacheManager<K, V> {
    private final Map<K, V> cache = new HashMap<>();
    private final Object lock = new Object();
    private final EvictionPolicy<K> evictionPolicy;
    private final int size;

    public CacheManager(EvictionPolicy<K> evictionPolicy, int size) {
        this.evictionPolicy = evictionPolicy;
        this.size = size;
    }


    public void insert(K key, V value) {
        synchronized (lock) {
            if (cache.size() == size) {
                //evict key from the cache to free up space
                K evictedKey = evictionPolicy.evictKey();
                System.out.println(format("Cache is full. Evicting key %s from cache", evictedKey));
                cache.remove(evictedKey);
            }
            System.out.println(format("Inserting key %s in cache", key));
            cache.put(key, value);
            evictionPolicy.keyAccessed(key);
        }
    }

    public V get(K key) {
        V value = cache.get(key);
        if (value == null) System.out.println(format("Key %s is not present in cache", key));
        else {
            evictionPolicy.keyAccessed(key);
            System.out.println(format("Retrieving key %s from cache", key));
        }
        return value;
    }
}
