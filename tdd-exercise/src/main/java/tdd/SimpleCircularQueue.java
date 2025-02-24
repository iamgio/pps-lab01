package tdd;

import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class SimpleCircularQueue<T> implements CircularQueue<T> {
    private final List<T> data;
    private final int size;

    public SimpleCircularQueue(int size) {
        this.data = new LinkedList<>();
        this.size = size;
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
        this.data.add(value);
    }
}
