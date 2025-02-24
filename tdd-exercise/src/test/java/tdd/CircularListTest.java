package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private static final int SIZE = 3;

    private CircularQueue<Integer> queue;

    @BeforeEach
    void setup() {
        this.queue = new SimpleCircularQueue<>(SIZE);
    }

    @Test
    void initialization() {
        assertTrue(queue.isEmpty());
    }

    private void enqueueIncrementally(int times) {
        for (int i = 0; i < times; i++) {
            queue.enqueue(i);
        }
    }

    @Test
    void linearEnqueueOnce() {
        queue.enqueue(1);
        assertEquals(1, queue.size());
    }

    @Test
    void linearEnqueueToFullSize() {
        enqueueIncrementally(SIZE);
        assertEquals(SIZE, queue.size());
    }

    @Test
    void linearDequeueOnce() {
        queue.enqueue(1);
        assertEquals(1, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void linearDequeueToFullSize() {
        enqueueIncrementally(SIZE);
        assertEquals(0, queue.dequeue());
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
    }

    @Test
    void circularEnqueueOnce() {
        enqueueIncrementally(SIZE + 1);
        assertEquals(SIZE, queue.size());
    }

    @Test
    void circularEnqueueToFullSize() {
        enqueueIncrementally(SIZE * 2);
        assertEquals(SIZE, queue.size());
    }

    @Test
    void circularDequeueOnce() {
        enqueueIncrementally(SIZE + 1);
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void circularDequeueToTripleSize() {
        enqueueIncrementally(SIZE * 3);
        assertEquals(6, queue.dequeue());
        assertEquals(7, queue.dequeue());
        assertEquals(8, queue.dequeue());
        assertTrue(queue.isEmpty());
    }
}
