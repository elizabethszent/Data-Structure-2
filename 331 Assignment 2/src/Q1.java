import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Class to determine if a destination vertex is reachable from a source vertex in a directed graph.
 */
public class Q1 {
    private ArrayList<Edge> graph;

    /**
     * Constructs a Q1 object with the given graph.
     *
     * @param graph the directed graph represented as a list of edges
     */
    public Q1(ArrayList<Edge> graph) {
        this.graph = graph;
    }
    
    /**
     * Checks if there exists a path from source vertex to destination vertex in the graph.
     *
     * @param src     the source vertex
     * @param dest    the destination vertex
     * @param visited a set to track visited vertices to avoid cycles
     * @return true if a path exists from source to destination, false otherwise
     */
    public boolean path(int src, int dest, Set<Integer> visited) {
        if (src == dest) {
            return true; // Found the destination
        }

        visited.add(src);

        for (Edge edge : graph) {
            if (edge.getX() == src && !visited.contains(edge.getY())) {
                if (path(edge.getY(), dest, visited)) {
                    return true; // Path found through this edge
                }
            }
        }

        return false; // No path found from src to dest
    }
    
    /**
     * Main method to test the Q1 class.
     *
     * @param args command line arguments (not used)
     */

    public static void main(String[] args) {
        ArrayList<Edge> graph = new ArrayList<>();
        graph.add(new Edge(0, 6));
        graph.add(new Edge(6, 7));
        graph.add(new Edge(7, 3));
        graph.add(new Edge(3, 5));
        graph.add(new Edge(4, 6));

        Q1 q1 = new Q1(graph);

        int src1 = 4;
        int dest1 = 5;
        Set<Integer> visited1 = new HashSet<>();
        boolean result1 = q1.path(src1, dest1, visited1);
        System.out.println("Output for Graph 1: " + result1); // Expected output: true

        int src2 = 5;
        int dest2 = 0;
        Set<Integer> visited2 = new HashSet<>();
        boolean result2 = q1.path(src2, dest2, visited2);
        System.out.println("Output for Graph 2: " + result2); // Expected output: false
    }
}

