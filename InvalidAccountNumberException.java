package module4_activity5;


/**
 * Checked exception thrown when the account number length is invalid.
 */
public class InvalidAccountNumberException extends Exception {
    public InvalidAccountNumberException(String message) {
        super(message);
    }
}

