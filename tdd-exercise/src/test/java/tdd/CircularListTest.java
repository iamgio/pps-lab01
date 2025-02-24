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

    @Test
    void linearEnqueueOnce() {
        queue.enqueue(1);
        assertEquals(1, queue.size());
    }

    @Test
    void linearEnqueueThrice() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(3, queue.size());
    }

    @Test
    void linearDequeueOnce() {
        queue.enqueue(1);
        assertEquals(1, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void linearDequeueTrice() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
    }
}
