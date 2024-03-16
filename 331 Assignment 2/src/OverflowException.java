/**
 * Exception thrown when attempting to add an element to a full data structure.
 */
public class OverflowException extends RuntimeException {
	
    /**
     * Constructs a new OverflowException with no detail message.
     */
	public OverflowException() {
	}

    /**
     * Constructs a new OverflowException with the specified detail message.
     *
     * @param message the detail message
     */
	public OverflowException(String message) {
		super(message);
	}
}
