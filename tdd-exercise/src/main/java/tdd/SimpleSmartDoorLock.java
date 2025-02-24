package tdd;

/**
 *
 */
public class SimpleSmartDoorLock implements SmartDoorLock {

    public static final int INITIAL_PIN = 0;
    private static final int MIN_PIN = 0;
    private static final int MAX_PIN = 9999;

    private boolean locked;
    private int pin;

    public SimpleSmartDoorLock() {
        this.reset();
    }

    @Override
    public void setPin(int pin) {
        if (pin > MAX_PIN || pin < MIN_PIN) {
            throw new IllegalArgumentException("Only 4-digits positive pins are allowed.");
        }

        this.pin = pin;
    }

    @Override
    public void unlock(int pin) {
        if (pin == this.pin) {
            this.locked = false;
        }
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
        return false;
    }

    @Override
    public int getMaxAttempts() {
        return 0;
    }

    @Override
    public int getFailedAttempts() {
        return 0;
    }

    @Override
    public void reset() {
        this.locked = true;
        this.pin = INITIAL_PIN;
    }
}
