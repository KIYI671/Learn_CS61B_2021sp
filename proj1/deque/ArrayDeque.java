package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T>, Deque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private final int initSize = 8;
    private final int resetSize = 16;

    public ArrayDeque() {
        items = (T[]) new Object[initSize];
        size = 0;
        nextFirst = items.length / 2;
        nextLast = nextFirst + 1;
    }

    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        size += 1;
        if (nextFirst > 0) {
            nextFirst -= 1;
        } else {
            nextFirst = items.length - 1;
        }
    }

    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        size += 1;
        if (nextLast == items.length - 1) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = 1; i <= size; i++) {
            int index = i + nextFirst;
            if (index >= items.length - 1) {
                index -= items.length;
            }
            System.out.printf(items[index].toString() + ' ');
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size <= 0) {
            return null;
        }
        if (items.length >= resetSize && size <= items.length / 4) {
            resize(items.length / 2);
        }
        if (nextFirst == items.length - 1) {
            nextFirst = 0;
        } else {
            nextFirst += 1;
        }
        size -= 1;
        return items[nextFirst];
    }

    @Override
    public T removeLast() {
        if (size <= 0) {
            return null;
        }
        if (items.length >= resetSize && size <= items.length / 4) {
            resize(items.length / 2);
        }
        if (nextLast == 0) {
            nextLast = items.length - 1;
        } else {
            nextLast -= 1;
        }
        size -= 1;

        return items[nextLast];
    }

    @Override
    public T get(int index) {
        if (size < index || index < 0) {
            return null;
        }
        int i = nextFirst + 1 + index;
        if (i >= items.length) {
            i -= items.length;
        }
        return items[i];
    }

    private void resize(int capacity) {
        T[] t = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            int j = nextFirst + i + 1;
            if (j >= items.length) {
                j -= items.length;
            }
            t[i] = items[j];
        }
        nextFirst = capacity - 1;
        nextLast = size;
        items = t;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int wizPos;

        ArrayDequeIterator() {
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            return wizPos < size;
        }

        @Override
        public T next() {
            T returnItem = get(wizPos);
            wizPos++;
            return returnItem;
        }
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Deque && ((Deque<?>) o).size() == this.size) {
            for (int i = 0; i < size; i++) {
                if (((Deque<?>) o).get(i) != this.get(i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
