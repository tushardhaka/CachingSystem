package com.caching.system.evictionpolicy;

import com.caching.system.algo.DoublyLinkedList;
import com.caching.system.algo.DoublyLinkedListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key>{

    //private DoublyLinkedList<Key> dll;
    //private Map<Key, DoublyLinkedListNode<Key>> mapper;
    private List<Key> keyList;

    public LRUEvictionPolicy() {
        //this.dll = new DoublyLinkedList<>();
        //this.mapper = new HashMap<>();
        this.keyList = new ArrayList<>();
    }

    @Override
    public void keyAccessed(Key key) {
        if(keyList.contains(key)){
            keyList.remove(key);
            System.out.println("capacity - "+keyList.size());
            keyList.add(keyList.size(), key);
            System.out.println("capacity - "+keyList.size());
        }
        else{
            keyList.add(keyList.size(), key);
        }
    }

    @Override
    public Key evictKey() {
        Key key = keyList.get(0);
        keyList.remove(0);
        System.out.println("Key evicted - "+key+", new capacity - "+keyList.size());
        return key;
    }
}
