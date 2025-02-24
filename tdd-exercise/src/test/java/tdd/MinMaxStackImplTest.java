package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    private MinMaxStack stack;

    @BeforeEach
    void setup() {
        this.stack = new SimpleMinMaxStack();
    }

    @Test
    void initiallyEmpty() {
        assertTrue(stack.isEmpty());
        assertThrows(IllegalStateException.class, () -> stack.pop());
        assertThrows(IllegalStateException.class, () -> stack.peek());
    }

    @Test
    void pushOnce() {
        stack.push(1);
        assertAll(() -> assertFalse(stack.isEmpty()), () -> assertEquals(1, stack.size()));
    }

    @Test
    void pushPeekOnce() {
        final int value = 1;
        stack.push(value);

        assertEquals(value, stack.peek());
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
    }

    @Test
    void pushPopOnce() {
        final int value = 1;
        stack.push(value);

        assertEquals(value, stack.pop());
        assertTrue(stack.isEmpty());
    }

    private void pushIncrementally(int times) {
        for (int i = 0; i < times; i++) {
            stack.push(i);
        }
    }

    @Test
    void pushPopMultipleTimes() {
        int times = 4;
        pushIncrementally(times);

        assertEquals(3, stack.peek());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.peek());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertEquals(0, stack.pop());
        assertTrue(stack.isEmpty());
    }
}