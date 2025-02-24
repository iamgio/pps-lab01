package tdd;

import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class SimpleCircularQueue<T> implements CircularQueue<T> {
    private final List<T> data;
    private final int maxSize;
    private int index = 0;

    public SimpleCircularQueue(int maxSize) {
        this.data = new LinkedList<>();
        this.maxSize = maxSize;
    }

    @Override
    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    @Override
    public int size() {
        return this.data.size();
    }

    @Override
    public void enqueue(T value) {
        if (index >= this.size()) {
            this.data.add(value);
        } else {
            this.data.set(index, value);
        }

        index = (index + 1) % maxSize;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }

        return this.data.remove(0);
    }
}
