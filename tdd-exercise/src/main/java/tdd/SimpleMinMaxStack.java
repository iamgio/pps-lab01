package tdd;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link MinMaxStack} implementation.
 */
public class SimpleMinMaxStack implements MinMaxStack {

    private final List<Integer> list = new ArrayList<>();

    private int min = Integer.MAX_VALUE;

    @Override
    public void push(int value) {
        this.list.add(value);

        if (value < min) {
            min = value;
        }
    }

    private void checkNotEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
    }

    private int getLastIndex() {
        checkNotEmpty();
        return this.list.size() - 1;
    }

    @Override
    public int pop() {
        return this.list.remove(this.getLastIndex());
    }

    @Override
    public int peek() {
        return this.list.get(this.getLastIndex());
    }

    @Override
    public int getMin() {
        return this.min;
    }

    @Override
    public int getMax() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public int size() {
        return this.list.size();
    }
}
