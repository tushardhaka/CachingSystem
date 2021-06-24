package com.caching.system.storage;

import com.caching.system.exceptions.NotFoundException;
import com.caching.system.exceptions.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value>{

    private final int capacity;
    private Map<Key, Value> storage;

    public HashMapBasedStorage(int capacity) {
        this.capacity = capacity;
        storage = new HashMap<>();
    }


    @Override
    public void add(Key key, Value value) throws StorageFullException {
        if(isStorageFull()){
            throw new StorageFullException("Storage full, evict some key");
        }
        storage.put(key, value);

    }

    @Override
    public void remove(Key key) throws NotFoundException{
        if (!storage.containsKey(key)){
            throw new NotFoundException(key + "doesn't exist in cache.");
        }
        storage.remove(key);
    }

    @Override
    public Value get(Key key) throws NotFoundException {

        if(!storage.containsKey(key)){
            throw new NotFoundException(key+ " not found");
        }
        return storage.get(key);
    }

    private boolean isStorageFull() {
        return storage.size() == capacity;
    }
}
