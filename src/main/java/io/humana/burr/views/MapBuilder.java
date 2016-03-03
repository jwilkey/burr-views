package io.humana.burr.views;

import java.util.Map;

public interface MapBuilder<T,V> {
    MapBuilder<T, V> put(T key, V value);
    Map<T,V> build();
}
