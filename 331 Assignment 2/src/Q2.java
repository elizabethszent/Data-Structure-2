import java.util.ArrayList;
import java.util.Collections;

/**
 * Class to perform specific operations on a queue as described in Exercise 2.
 */
public class Q2 {

	/**
	 * Reverses the given queue by appending its elements in reverse order.
	 *
	 * @param initialQ the initial queue to be reversed
	 * @param <T>      the type of elements in the queue
	 * @return the updated queue after reversing
	 * @throws UnderflowException if the initial queue is empty
	 * @throws OverflowException  if the updated queue is full
	 */
	public <T> Queue<T> reverse(Queue<T> initialQ) throws UnderflowException, OverflowException {
		Stack<T> update = new Stack<>();
		Queue<T> updatedQ = new Queue<>();

		// Push elements from initial queue to stack
		while (!initialQ.isEmpty()) {
			update.push(initialQ.dequeue());
		}

		// Pop elements from stack to updated queue (reversing order)
		while (!update.isEmpty()) {
			updatedQ.enqueue(update.pop());
		}
		return updatedQ;
	}
	
    /**
     * Divides each value of the queue by its following value.
     *
     * @param updatedQ the updated queue
     * @return the queue after division
     * @throws UnderflowException if the updated queue is empty
     */
	public Queue<Integer> divide(Queue<Integer> updatedQ) throws UnderflowException {
		Queue<Integer> dividedQ = new Queue();
		
		// Perform division for each pair of consecutive elements in the queue
		while (!updatedQ.isEmpty()) {
			int current = updatedQ.dequeue().intValue();

			// If queue becomes empty, enqueue the current value
			if (updatedQ.isEmpty()) {

				dividedQ.enqueue(new Integer(current));

			} else {
				int previous = updatedQ.peek().intValue();

				// Check if denominator is 0 to avoid division by zero
				if (previous == 0 || current == 0) {

					dividedQ.enqueue(new Integer(0));
				} else if (previous <= current) {

					int divide = current / previous;

					dividedQ.enqueue(new Integer(divide));
				} else if (previous > current) {

					int divide = previous / current;

					dividedQ.enqueue(new Integer(divide));
				}
			}

		}

		return dividedQ;

	}
	/**
     * Sorts the queue in descending order and removes duplicates.
     *
     * @param dividedQ the queue after division
     * @return the sorted queue with removed duplicates
     * @throws UnderflowException if the queue is empty
     */
	public ArrayList sort(Queue<Integer> dividedQ) throws UnderflowException {
		ArrayList<Integer> sorted = new ArrayList<Integer>();
		ArrayList<Integer> removed = new ArrayList<Integer>();
		
		// Transfer elements from queue to list
		while (!dividedQ.isEmpty()) {
			sorted.add(dividedQ.dequeue());
		}
		// Sort the list in descending order
		for (int i = 1; i < sorted.size(); i++) {
			for (int j = 0; j < i; j++) {

				if (sorted.get(i) < sorted.get(j)) {
					int curr = sorted.get(i);
					int prev = sorted.get(j);
					sorted.set(i, prev);
					sorted.set(j, curr);

				}
			}

		}
		// Remove duplicates while maintaining order
		for (Integer element : sorted) {

			if (!removed.contains(element)) {

				removed.add(element);
			}
		}

		return removed;

	}

}
