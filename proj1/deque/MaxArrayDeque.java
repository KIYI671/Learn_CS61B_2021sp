package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque {
    private Comparator myComparator;

    public MaxArrayDeque() {
        super();
    }

    public MaxArrayDeque(Comparator<T> c) {
        myComparator = c;
    }

    public T max() {
        if (this.size() == 0) {
            return null;
        }
        int maxIndex = 0;
        for (int i = 1; i < this.size(); i++) {
            if (myComparator.compare(this.get(maxIndex), this.get(i)) <= 0) {
                maxIndex = i;
            }
        }
        return (T) this.get(maxIndex);
    }

    public T max(Comparator<T> c) {
        if (this.size() == 0) {
            return null;
        }
        int maxIndex = 0;
        for (int i = 1; i < this.size(); i++) {
            if (c.compare((T) this.get(maxIndex), (T) this.get(i)) <= 0) {
                maxIndex = i;
            }
        }
        return (T) this.get(maxIndex);
    }
}
