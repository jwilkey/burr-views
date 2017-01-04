package com.tentkeep.burrviews;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class HashMapBuilder<T,V> implements MapBuilder<T,V> {

    private Map<T,V> map = new HashMap<>();

    @Override
    public MapBuilder<T, V> put(T key, V value) {
        map.put(key, value);
        return this;
    }

    @Override
    public Map<T,V> build() {
        Map<T,V> mapCopy = map;
        map = new HashMap<>();
        return mapCopy;
    }

}
