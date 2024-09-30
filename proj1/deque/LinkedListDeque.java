package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable<T>, Deque<T> {
    private class IntNode {
        private T item;
        private IntNode next;
        private IntNode prev;

        IntNode(T t, IntNode n, IntNode p) {
            item = t;
            next = n;
            prev = p;
        }
    }

    private int size;
    private IntNode sentinel;

    public LinkedListDeque() {
        sentinel = new IntNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        IntNode i = new IntNode(item, sentinel.next, sentinel);
        sentinel.next.prev = i;
        sentinel.next = i;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        IntNode i = new IntNode(item, sentinel, sentinel.prev);
        sentinel.prev.next = i;
        sentinel.prev = i;
        size += 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        if (size > 0) {
            IntNode n = sentinel;
            while (n.next != sentinel) {
                System.out.printf(n.next.item + " ");
                n = n.next;
            }
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size > 0) {
            IntNode t = sentinel.next;
            sentinel.next = t.next;
            t.next.prev = sentinel;
            size -= 1;
            return t.item;
        } else {
            return null;
        }
    }

    @Override
    public T removeLast() {
        if (size > 0) {
            IntNode t = sentinel.prev;
            sentinel.prev = t.prev;
            t.prev.next = sentinel;
            size -= 1;
            return t.item;
        } else {
            return null;
        }
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        IntNode n = sentinel.next;
        while (index > 0) {
            n = n.next;
            index -= 1;
        }
        return n.item;
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        IntNode n = sentinel.next;
        return recursive(index, n);
    }

    private T recursive(int index, IntNode n) {
        if (index == 0) {
            return n.item;
        }
        return recursive(index - 1, n.next);
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    private class LinkedListDequeIterator implements Iterator<T> {
        private int wizPos;

        LinkedListDequeIterator() {
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            return wizPos < size;
        }

        @Override
        public T next() {
            T returnItem = get(wizPos);
            wizPos += 1;
            return returnItem;
        }

    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o instanceof Deque && (((Deque<?>) o).size() == this.size)) {
            for (int i = 0; i < size; i++) {
                if (!this.get(i).equals(((Deque<?>) o).get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
