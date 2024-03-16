/**
 * UnderflowException represents an exception that occurs when an operation is attempted
 * on an empty data structure, such as popping from an empty stack or dequeueing from an empty queue.
 */
public class UnderflowException extends RuntimeException {
    /**
     * Constructs a new UnderflowException with no detail message.
     */
	public UnderflowException() {
	}

    /**
     * Constructs a new UnderflowException with the specified detail message.
     *
     * @param message the detail message
     */
	public UnderflowException(String message) {
		super(message);
	}
}
