package org.example;

import org.example.evictionPolicy.EvictionPolicy;
import org.example.evictionPolicy.FIFOEvictionPolicy;
import org.example.evictionPolicy.LRUEvictionPolicy;

public class Main {
    public static void main(String[] args) {
        //EvictionPolicy<Integer> evictionPolicy = new LRUEvictionPolicy<>();
        EvictionPolicy<Integer> evictionPolicy = new FIFOEvictionPolicy <>();
        CacheManager<Integer,String> cacheManager = new CacheManager<>(evictionPolicy, 2);

        //insert in cache
        cacheManager.insert(10, "rishabh");
        cacheManager.insert(11, "gautam");

        //retrieve from cache
        String val = cacheManager.get(11);
        System.out.println(val);

        cacheManager.insert(12, "zoe");

        //retrieve from cache
        String v1 = cacheManager.get(10);
        System.out.println(v1);
    }
}