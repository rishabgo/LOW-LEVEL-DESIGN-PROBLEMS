package org.example.evictionPolicy;

import org.example.Algorithm.Node;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class FIFOEvictionPolicy<K> implements EvictionPolicy<K> {
    private final Queue<K> queue = new LinkedList<>();

    @Override
    public K evictKey() {
        return Objects.requireNonNull(queue.poll());
    }

    @Override
    public void keyAccessed(K key) {
        queue.offer(key);
    }
}
