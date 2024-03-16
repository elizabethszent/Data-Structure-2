/**
 * Queue represents a linear data structure that follows the FIFO (First-In-First-Out) principle.
 *
 * @param <T> the type of elements stored in the queue
 */
public class Queue<T> implements QueueInterface<T> {
	private class Node<T> {
		private T value;
		private Node<T> next;
	}

	private Node<T> front = null; // Pointer to the front of the queue
	private Node<T> rear = null;  // Pointer to the rear of the queue

    /**
     * Constructs a new Queue object.
     */
	public Queue() {
	}

    /**
     * Retrieves the element at the front of the queue without removing it.
     *
     * @return the element at the front of the queue
     * @throws UnderflowException if the queue is empty
     */
	@Override
	public T peek() throws UnderflowException {
		if (!isEmpty())
			return front.value;
		else
			throw new UnderflowException("Cannot peek into an empty stack.");
	}

    /**
     * Adds an element to the rear of the queue.
     *
     * @param item the element to be added to the queue
     */
	@Override
	public void enqueue(T item) {
		Node<T> nn = new Node<T>();
		nn.value = item;
		nn.next = null;
		if (rear == null) {
			front = nn;
			rear = nn;
		} else {
			rear.next = nn;
			rear = rear.next;
			if (front == null) {
				front = rear;
			}
		}
	}
	
	/**
     * Removes and returns the element at the front of the queue.
     *
     * @return the element at the front of the queue
     * @throws UnderflowException if the queue is empty
     */
	@Override
	public T dequeue() throws UnderflowException {
		if (isEmpty()) {
			throw new UnderflowException("Cannot dequeue from an empty queue.");
		}
		T tmp = front.value;
		if (front == rear) {
			front = null;
			rear = null;
		} else {
			front = front.next;
		}
		return tmp;
	}

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
	@Override
	public boolean isEmpty() {
		return (front == null);
	}

    /**
     * Checks if the queue is full.
     *
     * @return always returns false since the queue is not bounded
     */
	@Override
	public boolean isFull() {
		return false;
	}

    /**
     * Returns a string representation of the queue.
     *
     * @return a string representation of the queue
     */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node<T> current = front;
		while (current != null) {
			sb.append(current.value);
			if (current.next != null) {
				sb.append(", ");
			}
			current = current.next;
		}
		sb.append("]");
		return sb.toString();
	}

    /**
     * Returns a string representation of the queue with hyphen separator.
     *
     * @return a string representation of the queue with hyphen separator
     */
	public String toString3() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node<T> current = front;
		while (current != null) {
			sb.append(current.value);
			if (current.next != null) {
				sb.append(" - ");
			}
			current = current.next;
		}
		sb.append("]");
		return sb.toString();
	}
}