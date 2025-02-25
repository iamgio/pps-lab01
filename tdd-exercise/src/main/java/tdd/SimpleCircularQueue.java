package tdd;

import java.util.LinkedList;
import java.util.List;

/**
 * {@link CircularQueue} implementation.
 */
public class SimpleCircularQueue<T> implements CircularQueue<T> {
    private static final int GET_AT_INDEX = 0;

    private final List<T> data;
    private final int maxSize;

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
        if (this.size() >= maxSize) {
            this.data.remove(GET_AT_INDEX);
        }
        this.data.add(value);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }

        return this.data.remove(GET_AT_INDEX);
    }
}
