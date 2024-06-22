package org.example.evictionPolicy;

public interface EvictionPolicy<K> {
     K evictKey();
     void keyAccessed(K key);
}
