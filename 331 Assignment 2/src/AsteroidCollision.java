import java.util.ArrayList;
import java.util.List;
/**
 * Simulates asteroid collisions using stacks.
 */
public class AsteroidCollision {
	/**
     * Simulates asteroid collisions and returns the final state of surviving asteroids.
     *
     * @param asteroids array of asteroid sizes
     * @return array containing asteroids that survived collisions
     * @return array after simulating asteroid collisions
     * @throws UnderflowException if pop operation is attempted on an empty stack
     * @throws OverflowException  if push operation is attempted on a full stack
     */
	public static int[] simulateCollisions(int[] asteroids) throws UnderflowException, OverflowException {
		int maxstack = asteroids.length; // Maximum stack size is set to the length of the asteroids array
		BoundedStack<Integer> resultStack = new BoundedStack<>(Integer.class, maxstack); // Create a bounded stack to hold the resulting asteroids
		
		// Iterate through the asteroids array
		for (int i = 0; i < maxstack; i++) {
			int curr = asteroids[i]; // Current asteroid
			
			// Check if the result stack is not empty
			if (!resultStack.isEmpty()) {
				int top = resultStack.peek(); // Retrieve the top element of the stack

				// Conditions for collision resolution
				if (resultStack.isEmpty() || (curr > 0 && top > 0) || (curr < 0 && top < 0)) {
					resultStack.push(curr); // If no collision, push the current asteroid onto the stack
				} else if (Math.abs(curr) > Math.abs(top)) {
					resultStack.pop(); // If the current asteroid destroys the top asteroid, pop the top asteroid
					resultStack.push(curr); // Then push the current asteroid onto the stack
				} else if (Math.abs(curr) == Math.abs(top)) {
					resultStack.pop(); // If both asteroids are of equal size, destroy both by popping them
				}
			} else {
				resultStack.push(curr); // If the result stack is empty, push the current asteroid onto the stack
			}
		}

		// Convert the non-null elements of the stack to a List<Integer>
		List<Integer> resultList = new ArrayList<>();
		for (Integer item : resultStack.getStack()) {
			if (item != null) {
				resultList.add(item);
			}
		}

		// Convert the List<Integer> to an int[]
		int[] resultArray = new int[resultList.size()];
		for (int i = 0; i < resultList.size(); i++) {
			resultArray[i] = resultList.get(i);
		}

		return resultArray; // Return the resulting array of asteroids after collision simulation
	}
}
