package tdd;

/**
 *
 */
public class SimpleSmartDoorLock implements SmartDoorLock {

    public static final int INITIAL_PIN = 0;
    private static final int MIN_PIN = 0;
    private static final int MAX_PIN = 9999;
    private static final int MAX_ATTEMPTS = 3;

    private boolean locked;
    private boolean blocked;
    private int pin;
    private int attempts = 0;

    public SimpleSmartDoorLock() {
        this.reset();
    }

    @Override
    public void setPin(int pin) {
        if (pin > MAX_PIN || pin < MIN_PIN) {
            throw new IllegalArgumentException("Only 4-digits positive pins are allowed.");
        }

        if (this.locked || this.blocked) {
            throw new IllegalStateException("System is not open.");
        }

        this.pin = pin;
    }

    private void failAttempt() {
        this.attempts++;

        if (this.attempts >= MAX_ATTEMPTS) {
            this.blocked = true;
        }
    }

    @Override
    public void unlock(int pin) {
        if (this.blocked) {
            return;
        }

        if (pin == this.pin) {
            this.locked = false;
            return;
        }

        failAttempt();
    }

    @Override
    public void lock() {
        this.locked = true;
    }

    @Override
    public boolean isLocked() {
        return this.locked;
    }

    @Override
    public boolean isBlocked() {
        return this.blocked;
    }

    @Override
    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    @Override
    public int getFailedAttempts() {
        return this.attempts;
    }

    @Override
    public void reset() {
        this.locked = true;
        this.blocked = false;
        this.pin = INITIAL_PIN;
        this.attempts = 0;
    }
}
