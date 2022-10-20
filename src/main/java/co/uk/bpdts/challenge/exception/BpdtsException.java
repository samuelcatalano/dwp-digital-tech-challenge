package co.uk.bpdts.challenge.exception;

/**
 * @author Samuel Catalano
 * @since Jul 10, 2020
 */
public class BpdtsException extends Exception {

    public BpdtsException() {
        super();
    }

    public BpdtsException(String message) {
        super(message);
    }

    public BpdtsException(String message, Throwable cause) {
        super(message, cause);
    }

    public BpdtsException(Throwable cause) {
        super(cause);
    }

    protected BpdtsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}