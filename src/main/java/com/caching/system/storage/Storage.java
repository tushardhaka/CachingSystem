package com.caching.system.storage;

import com.caching.system.exceptions.NotFoundException;
import com.caching.system.exceptions.StorageFullException;

public interface Storage<Key, Value> {

    void add(Key key, Value value) throws StorageFullException;
    void remove(Key key);
    Value get(Key key) throws NotFoundException;


}
