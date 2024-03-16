import java.lang.reflect.Array;
import java.util.Arrays;
/**
 * BoundedStack represents a stack with a fixed maximum capacity.
 *
 * @param <T> the type of elements stored in the stack
 */
public class BoundedStack<T> implements StackInterface<T> {
	private T[] stack; // Array to store stack elements
	private int topIndex; // Index of the top element in the stack
	private Class<T> type; // Store the class type of elements in the stack
	
	/**
     * Constructs a new BoundedStack with the specified maximum size.
     *
     * @param clazz   the class type of elements to be stored in the stack
     * @param maxSize the maximum size of the stack
     */
	public BoundedStack(Class<T> clazz, int maxSize) {
		type = clazz; // Store the class type
		stack = (T[]) Array.newInstance(clazz, maxSize); // Create the stack array of specified size
        topIndex = -1; // Initialize topIndex to indicate an empty stack
	}

	/**
     * Adds an item to the top of the stack.
     *
     * @param item the item to be pushed onto the stack
     * @throws OverflowException if the stack is full
     */
	@Override
	public void push(T item) throws OverflowException {
		if (!isFull()) {
			topIndex++; // Increment topIndex to point to the next available position
			stack[topIndex] = item; // Add the item to the stack
		} else {
			throw new OverflowException("Cannot push onto a full stack");
		}

	}
	
	/**
     * Removes and returns the item at the top of the stack.
     *
     * @return the item at the top of the stack
     * @throws UnderflowException if the stack is empty
     */
	@Override
	public T pop() throws UnderflowException {
		if (!isEmpty()) {
			T tmp = stack[topIndex]; // Retrieve the top item
			stack[topIndex] = null; // Remove the top item from the stack
			topIndex--;  // Decrement topIndex to point to the next item
			return tmp;
		} else
			throw new UnderflowException("Cannot pop from an empty stack.");
	}

	/**
     * Returns the item at the top of the stack without removing it.
     *
     * @return the item at the top of the stack
     * @throws UnderflowException if the stack is empty
     */
	@Override
	public T peek() throws UnderflowException {
		if (!isEmpty())
			return stack[topIndex]; // Return the top item without removing it
		else
			throw new UnderflowException("Cannot peek to an empty stack.");
	}


    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
	@Override
	public boolean isEmpty() {
		return (topIndex == -1);
	}

	/**
     * Checks if the stack is full.
     *
     * @return true if the stack is full, false otherwise
     */
	@Override
	public boolean isFull() {
		return (topIndex == (stack.length - 1));
	}
	
    /**
     * Returns a string representation of the stack.
     *
     * @return a string representation of the stack
     */
	@Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i <= topIndex; i++) {
            result.append(stack[i]);
            if (i < topIndex) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
    /**
     * Returns a string representation of the stack with hyphen separator.
     *
     * @return a string representation of the stack with hyphen separator
     */
    public String toString3() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i <= topIndex; i++) {
            result.append(stack[i]);
            if (i < topIndex) {
                result.append(" - ");
            }
        }
        result.append("]");
        return result.toString();
    }
    
    /**
     * Retrieves the stack array.
     *
     * @return the stack array
     */
	public T[] getStack() {
        return stack;
	    }
	
    /**
     * Retrieves the class type of elements stored in the stack.
     *
     * @return the class type of elements stored in the stack
     */
    public Class<T> getType() {
    	return type; // Return the stored class type
    }
	
}
