package module4_activity5;


/**
 * Unchecked exception thrown when the account number contains non-digit characters.
 */
public class InvalidAccountFormatException extends RuntimeException {
    public InvalidAccountFormatException(String message) {
        super(message);
    }
}

