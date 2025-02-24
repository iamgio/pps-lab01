package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmartDoorLockTest {

    public static final int PIN = 1234;
    private SmartDoorLock lock;

    @BeforeEach
    void setup() {
        this.lock = new SimpleSmartDoorLock();
    }

    @Test
    void initiallyLocked() {
        assertTrue(lock.isLocked());
    }

    @Test
    void initialUnlock() {
        lock.unlock(SimpleSmartDoorLock.INITIAL_PIN);
        assertFalse(lock.isLocked());
    }

    @Test
    void pinUnlock() {
        lock.setPin(PIN);
        lock.unlock(PIN);
        assertFalse(lock.isLocked());
    }
}
