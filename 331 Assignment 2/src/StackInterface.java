/**
 * StackInterface represents the interface for a generic stack data structure.
 *
 * @param <T> the type of elements stored in the stack
 */
public interface StackInterface<T> {
    /**
     * Adds an item to the top of the stack.
     *
     * @param item the item to be added to the stack
     * @throws OverflowException if the stack is full
     */
		public void push(T item) throws OverflowException;
		   /**
	     * Removes and returns the item at the top of the stack.
	     *
	     * @return the item at the top of the stack
	     * @throws UnderflowException if the stack is empty
	     * Postcondition: If (stack is not full)item is added at the top of the stack else throw Overflow exception
		*/
		public T pop() throws UnderflowException;
	    /**
	     * Retrieves the item at the top of the stack without removing it.
	     *
	     * @return the item at the top of the stack
	     * @throws UnderflowException if the stack is empty
	     * Postcondition: If (stack is not empty) remove and return top item else throw Underflow exception
	     */
		public T peek() throws UnderflowException;
	    /**
	     * Checks if the stack is empty.
	     *
	     * @return true if the stack is empty, false otherwise
	     *Postcondition: If (stack is not empty) return top item else throw Underflow exception
	     */
		public boolean isEmpty();
		/**
	     * Checks if the stack is full.
	     *
	     * @return true if the stack is full, false otherwise
	     */
		public boolean isFull();

}
