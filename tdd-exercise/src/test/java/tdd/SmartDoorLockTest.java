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

    private void updateInitialPin() {
        lock.setPin(PIN);
    }

    private void updateInitialPinAndLock() {
        this.updateInitialPin();
        lock.lock();
    }

    @Test
    void initiallyUnlocked() {
        assertFalse(lock.isLocked());
    }

    @Test
    void pinUnlock() {
        lock.lock();
        lock.unlock(SimpleSmartDoorLock.INITIAL_PIN);
        assertFalse(lock.isLocked());
    }

    @Test
    void pinLock() {
        updateInitialPinAndLock();
        assertTrue(lock.isLocked());
    }

    @Test
    void pinLockUnlock() {
        updateInitialPinAndLock();
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
        updateInitialPinAndLock();
        lock.unlock(SimpleSmartDoorLock.INITIAL_PIN);
        assertEquals(1, lock.getFailedAttempts());
    }

    private void block() {
        updateInitialPinAndLock();
        for (int i = 0; i < lock.getMaxAttempts(); i++) {
            lock.unlock(SimpleSmartDoorLock.INITIAL_PIN);
        }
    }

    @Test
    void failToBlock() {
        block();
        assertTrue(lock.isBlocked());
    }

    @Test
    void rejectUnlockingWhileBlocked() {
        block();
        lock.unlock(PIN);
        assertTrue(lock.isLocked());
    }

    @Test
    void rejectSettingPinWhileBlocked() {
        block();
        assertThrows(IllegalStateException.class, () -> lock.setPin(PIN));
    }

    @Test
    void reset() {
        updateInitialPin();
        lock.reset();

        assertAll(
                () -> assertFalse(lock.isLocked()),
                () -> assertEquals(0, lock.getFailedAttempts()),
                () -> assertFalse(lock.isBlocked())
        );
    }
}
