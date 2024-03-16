import java.util.Arrays;
/**
 * Test class for AsteroidCollision simulation.
 */
public class AsteroidCollisionTest {
    /**
     * Main method to execute the simulation.
     *
     * @param args command line arguments (not used)
     */
	public static void main(String[] args) {
		int[] inputAsteroids = {7, 16, -16, -7, 5, -5, -21, 2, 2, 34, -9}; // Input array of asteroids
		try {
			int[] finalAsteroids = AsteroidCollision.simulateCollisions(inputAsteroids);// Simulate asteroid collisions
            // Print the final state of surviving asteroids
			System.out.println("Final asteroids: " + Arrays.toString(finalAsteroids));
		} catch (UnderflowException | OverflowException e) {
			e.printStackTrace(); // Print stack trace in case of exception
		}
	}
}
