package dev.clonopoly.datatypes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CyclicIterator<T> implements Iterator<T> {
    private final List<T> list;
    private int index = 0;

    public CyclicIterator(List<T> list) {
        this.list = list;
    }

    public CyclicIterator(T[] array) { this.list = Arrays.asList(array);}

    @Override
    public boolean hasNext() {
        return !list.isEmpty();
    }

    @Override
    public T next() {
        if (list.isEmpty()) {
            throw new IllegalStateException("No players available");
        }
        T item = list.get(index);
        index = (index + 1) % list.size();
        return item;
    }

    public List<T> toList() {
        return list;
    }
}