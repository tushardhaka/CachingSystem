package com.caching.system.evictionpolicy;

public interface EvictionPolicy<Key> {

    void keyAccessed(Key key);

    Key evictKey();

}
