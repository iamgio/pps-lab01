package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    public static final int PIN = 1234;
    public static final int TOO_LOW_INVALID_PIN = -1;
    public static final int INVALID_PIN_TOO_HIGH = 12345;
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

    @Test
    void invalidPinTooLow() {
        assertThrows(IllegalArgumentException.class, () -> lock.setPin(TOO_LOW_INVALID_PIN));
    }

    @Test
    void invalidPinTooHigh() {
        assertThrows(IllegalArgumentException.class, () -> lock.setPin(INVALID_PIN_TOO_HIGH));
    }

    @Test
    void failAttempt() {
        lock.setPin(PIN);
        lock.unlock(SimpleSmartDoorLock.INITIAL_PIN);
        assertEquals(1, lock.getFailedAttempts());
    }

    @Test
    void failToBlock() {
        lock.setPin(PIN);
        for (int i = 0; i < lock.getMaxAttempts(); i++) {
            lock.unlock(SimpleSmartDoorLock.INITIAL_PIN);
        }
        assertTrue(lock.isBlocked());
    }
}
