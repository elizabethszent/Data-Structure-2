
import java.util.ArrayList;
/**
 * Class to demonstrate the implementation of Q2 operations on a queue.
 */
public class Q2implementation {
    /**
     * Main method to demonstrate Q2 operations.
     *
     * @param args the command-line arguments (not used)
     * @throws UnderflowException if the initial queue is empty
     * @throws OverflowException  if the updated queue is full
     */
	public static void main(String[] args) throws UnderflowException, OverflowException {
		// Create an instance of Q2
		Q2 q2 = new Q2();

		// Create the input queue
		Queue<Integer> initialQ = new Queue<>();
		initialQ.enqueue(3);
		initialQ.enqueue(15);
		initialQ.enqueue(0);
		initialQ.enqueue(18);
		initialQ.enqueue(4);
		initialQ.enqueue(10);
		initialQ.enqueue(2);
		initialQ.enqueue(5);
		initialQ.enqueue(25);
		System.out.println(initialQ);
		
		// Perform operations
		Queue<Integer> updatedQ = q2.reverse(initialQ);
	    // Print the reversed queue
        System.out.println("Reversed Queue: " + updatedQ);
		Queue<Integer> dividedQ = q2.divide(updatedQ);
		System.out.println("divided Queue: " + dividedQ);
		ArrayList<Integer> sorted = q2.sort(dividedQ);
		System.out.println("sorted Queue: " + sorted);
		//System.out.println(updatedQ.toString());
	}
}
