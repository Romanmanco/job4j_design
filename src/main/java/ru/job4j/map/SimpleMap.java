package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleMap<K, V> implements Map<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean rsl = false;
        expand();
        int index = checkNull(key);
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
            rsl = true;
        }
        return rsl;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return (capacity - 1) & hash(hash);
    }

    private void expand() {
        if (count >= capacity * LOAD_FACTOR) {
            capacity *= 2;
            MapEntry<K, V>[] tempTable = new MapEntry[capacity];
            for (MapEntry<K, V> entry : table) {
                if (entry != null) {
                    int newIndex = indexFor(hash(entry.key.hashCode()));
                    tempTable[newIndex] = entry;
                }
            }
            table = tempTable;
        }
    }

    private int checkNull(K key) {
        int hashCode = key == null ? 0 : key.hashCode();
        return indexFor(hashCode);
    }

    @Override
    public V get(K key) {
        V result = null;
        int index = checkNull(key);
        MapEntry<K, V> mapEntry = table[index];
        if (mapEntry != null && Objects.equals(mapEntry.key, key)) {
            result = mapEntry.value;
        }
        return result;
    }

    @Override
    public boolean remove(K key) {
        boolean result = false;
        int index = checkNull(key);
        if (table[index] != null && Objects.equals(table[index].key, key)) {
            table[index] = null;
            modCount++;
            count--;
            result = true;
        }
        return result;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            private final int expectedModCount = modCount;
            private int index;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (index < table.length && table[index] == null) {
                    index++;
                }
                return index < table.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].key;
            }
        };
    }

    private static class MapEntry<K, V> {
        K key;
        V value;
        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        SimpleMap<Integer, Integer> sm = new SimpleMap<>();
        for (int i = 0; i < 8; i++) {
            sm.put(i, i);
        }
    }
}
