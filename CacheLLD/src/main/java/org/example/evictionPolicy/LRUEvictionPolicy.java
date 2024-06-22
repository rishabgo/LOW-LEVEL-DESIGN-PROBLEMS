package org.example.evictionPolicy;

import org.example.Algorithm.DoublyLinkedList;
import org.example.Algorithm.Node;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K> {
    private final DoublyLinkedList<K> dll = new DoublyLinkedList<>();
    private final Map<K, Node<K>> map = new HashMap<>();

    @Override
    public K evictKey() {
        Node<K> node = dll.getLastNode();
        dll.deleteNode(node);
        map.remove(node.getElement());
        return node.getElement();
    }

    @Override
    public void keyAccessed(K key) {
        if (map.containsKey(key)) {
            Node<K> node = map.get(key);
            dll.deleteNode(node);
            dll.insertNode(node);
        } else {
            Node<K> node = new Node<>(key);
            dll.insertNode(node);
            map.put(key, node);
        }

    }
}
