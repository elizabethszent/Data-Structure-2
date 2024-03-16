import java.util.HashSet;
import java.util.Set;
/**
 * Q3 class implements a Java program to reverse a stack using the queue data structure.
 * It also finds the unique elements from the reversed stack and generates a new queue with the elements in FIFO order.
 */
public class Q3 {
    /**
     * Main method to demonstrate the functionality of reversing a stack and generating a queue with unique elements.
     * 
     * @param args command line arguments (not used)
     * @throws OverflowException if there is an overflow error in stack operations
     * @throws UnderflowException if there is an underflow error in stack operations
     */
	public static void main(String[] args) throws OverflowException, UnderflowException {
		BoundedStack<Integer> stack = new BoundedStack<>(Integer.class, 12);

		// Push elements into the stack
		int[] elements = { 2, 9, 3, 1, 8, 9, 0, 7, 8, 4, 5, 3 };
		for (int element : elements) {
			stack.push(element);

		}
		System.out.println("Initial stack" + stack.toString3());

		// Reverse the stack
		BoundedStack<Integer> reversedStack = reverseStack(stack);

		// Print the reversed stack
		System.out.println("Output Reversed Stack: " + reversedStack.toString3());
		
		BoundedStack<Integer> reversed = reverseStack(reversedStack);

		// Generate unique queue
		Queue<Integer> uniqueQueue = generateUniqueQueue(reversed);

		// Print the queue with unique values
		System.out.println("Output Queue with unique values: " + uniqueQueue.toString3());
	}
	
    /**
     * Reverses a given stack using a queue.
     * 
     * @param stack the stack to be reversed
     * @return the reversed stack
     * @throws OverflowException if there is an overflow error in stack or queue operations
     * @throws UnderflowException if there is an underflow error in stack or queue operations
     */
	public static <T> BoundedStack<T> reverseStack(BoundedStack<T> stack) throws OverflowException, UnderflowException {
		Queue<T> queue = new Queue<>();

		// Step 1: Pop elements from the stack and enqueue into the queue
		while (!stack.isEmpty()) {
			T element = stack.pop();
			queue.enqueue(element);
		}

		BoundedStack<T> reversedStack = new BoundedStack<>(stack.getType(), stack.getStack().length);

		// Step 2: Dequeue elements from the queue and push into the reversed stack
		while (!queue.isEmpty()) {
			T element = queue.dequeue();
			reversedStack.push(element);
		}

		return reversedStack;
	}
	
	/**
     * Generates a queue with unique elements from a given stack.
     * 
     * @param stack the stack from which unique elements are to be extracted
     * @return a queue containing the unique elements in FIFO order
     * @throws OverflowException if there is an overflow error in stack or queue operations
     * @throws UnderflowException if there is an underflow error in stack or queue operations
     */
	public static <T> Queue<T> generateUniqueQueue(BoundedStack<T> stack)
			throws OverflowException, UnderflowException {
		Queue<T> Queuerepeated = new Queue<>(); // Queue to store elements that may repeat
		Queue<T> uniqueQueue = new Queue<>(); // Queue to store unique elements

		 // Iterate over the elements in the stack
		while (!stack.isEmpty()) {
			T value = stack.pop(); // Pop the top element from the stack
			boolean flag = true;

			// Check if the value is already present in the uniqueQueue
			while (!uniqueQueue.isEmpty()) {

				if (value == uniqueQueue.peek()) { // Check if the value matches the top element in uniqueQueue
					flag = false;  // If repeated value is found, set flag to false
				}

				// Move elements from uniqueQueue to repeatedQueue
				Queuerepeated.enqueue(uniqueQueue.dequeue());

			}
			
			 // If value is not found in uniqueQueue, add it to repeatedQueue
			if (flag == true) {
				Queuerepeated.enqueue(value);
			}

			// Move elements from repeatedQueue back to uniqueQueue
			while (!Queuerepeated.isEmpty())
				uniqueQueue.enqueue(Queuerepeated.dequeue());


		}

		return uniqueQueue;  // Return the queue with unique elements
	}
}