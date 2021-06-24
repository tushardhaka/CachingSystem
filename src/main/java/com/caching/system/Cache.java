package com.caching.system;

import com.caching.system.evictionpolicy.EvictionPolicy;
import com.caching.system.exceptions.NotFoundException;
import com.caching.system.exceptions.StorageFullException;
import com.caching.system.storage.Storage;

public class Cache<Key, Value> {

    private final EvictionPolicy<Key> evictionPolicy;
    private final Storage<Key, Value> storage;


    public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key key, Value value){
        try {
            this.storage.add(key, value);
            this.evictionPolicy.keyAccessed(key);
        }catch (StorageFullException sf){
            System.out.println("Storage full, need to evict key now");
            Key keyToEvict = this.evictionPolicy.evictKey();
            if(keyToEvict == null){
                throw new RuntimeException("Unexpected State. Storage full and no key to evict.");
            }
            this.storage.remove(keyToEvict);
            put(key, value);
        }
    }

    public Value get (Key key){
        try {
            Value value = this.storage.get(key);
            this.evictionPolicy.keyAccessed(key);
            return value;
        }catch (NotFoundException exception){
            System.out.println("Tried to access non-existing key.");
            return null;
        }

    }
}
