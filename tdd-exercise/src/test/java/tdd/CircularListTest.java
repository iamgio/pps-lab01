package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    public void initialization() {
        assertTrue(queue.isEmpty());
    }
}
