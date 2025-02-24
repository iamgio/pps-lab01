package example.exception;

/**
 * Exception thrown when a verification user ID does not match the account holder ID.
 */
public class MismatchingUserIdException extends RuntimeException {

    public MismatchingUserIdException(int id) {
        super("Invalid verification ID: " + id);
    }
}
