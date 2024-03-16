/**
 * Represents an edge between two vertices in a graph.
 */
public class Edge {
	    private int X; // X-coordinate of the edge
	    private int Y; // Y-coordinate of the edge

	    /**
	     * Constructs an Edge object with the given coordinates.
	     *
	     * @param X the X-coordinate of the edge
	     * @param Y the Y-coordinate of the edge
	     */
	    public Edge(int X, int Y) {
	        this.X = X; // Initialize X-coordinate
	        this.Y = Y; // Initialize Y-coordinate
	    }

	    /**
	     * Retrieves the X-coordinate of the edge.
	     *
	     * @return the X-coordinate of the edge
	     */
	    public int getX() {
	        return X; // Return the X-coordinate
	    }
	    
	    /**
	     * Retrieves the Y-coordinate of the edge.
	     *
	     * @return the Y-coordinate of the edge
	     */
	    public int getY() {
	        return Y; // Return the Y-coordinate
	    }
	

}
