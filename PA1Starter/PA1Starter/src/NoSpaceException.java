/**
 * Represents an exception to signal there is no more space for a certain event.
 * 
 * @author Brahma Dathan
 *
 */
public class NoSpaceException extends Exception {
    /**
     * Initializes the exception with an appropriate message.
     * 
     * @param message
     *            the message to be stored
     */
    public NoSpaceException(String message) {
        super(message);
    }
}
