/**
 * QueueInterface represents the interface for a generic queue data structure.
 *
 * @param <T> the type of elements stored in the queue
 */
public interface QueueInterface<T> {
    /**
     * Adds an item to the rear of the queue.
     *
     * @param item the item to be added to the queue
     * Precond: Queue is not full
     * Postcond: item is added to the rear
     */
	public void enqueue(T item);

	 /**
     * Removes and returns the item at the front of the queue.
     *
     * @return the item at the front of the queue
     * @throws UnderflowException if the queue is empty
     * 
     * Precond: Queue is not empty
     * Postcond:Front item removed & returned
     *
     */
	public T dequeue() throws UnderflowException;

	/**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
	public boolean isEmpty();

	/**
     * Checks if the queue is full.
     *
     * @return true if the queue is full, false otherwise
     */
	public boolean isFull();
	
	/**
     * Retrieves the item at the front of the queue without removing it.
     *
     * @return the item at the front of the queue
     * @throws UnderflowException if the queue is empty
     * Postcondition: If (queue is not empty) return top item else throw Underflow exception
     * 
     */  
	public T peek() throws UnderflowException;
	
}
