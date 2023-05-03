package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEM_SIZE = 10;
    private Object[] keys;
    private Object[] values;
    private int size;
    private int index;

    public StorageImpl() {
        keys = new Object[MAX_ITEM_SIZE];
        values = new Object[MAX_ITEM_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (equalsObjects(keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        keys[index] = key;
        values[index] = value;
        index++;
        size++;

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (equalsObjects(keys[i], key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean equalsObjects(Object first, Object second) {
        return (first == second || (first != null && first.equals(second)));
    }
}
