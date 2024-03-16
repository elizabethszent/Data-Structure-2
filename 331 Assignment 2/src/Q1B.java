import java.util.ArrayList;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Class to find the total number of routes with exactly m edges from a source vertex to a destination vertex
 * in a directed graph.
 */
public class Q1B {
    private ArrayList<Edge> graph;

    /**
     * Constructs a Q1B object with the given graph.
     *
     * @param graph the directed graph represented as a list of edges
     */
    public Q1B(ArrayList<Edge> graph) {
        this.graph = graph;
    }
    
    /**
     * Finds the total number of routes with exactly m edges from source vertex to destination vertex.
     *
     * @param src  the source vertex
     * @param dest the destination vertex
     * @param m    the number of edges in the routes
     * @return the total number of routes with exactly m edges from source to destination
     */
    public int countRoutes(int src, int dest, int m) {
        return countRoutesHelper(src, dest, m, 0, new HashSet<>());
    }

    /**
     * Recursive helper method to count routes with exactly m edges.
     *
     * @param src     the current source vertex
     * @param dest    the destination vertex
     * @param m       the number of edges in the routes
     * @param edges   the number of edges traversed so far
     * @param visited a set to track visited vertices to avoid cycles
     * @return the total number of routes with exactly m edges from source to destination
     */
    private int countRoutesHelper(int src, int dest, int m, int edges, Set<Integer> visited) {
        if (src == dest && m == edges) {
            return 1; // Found a route with exactly m edges
        }

        if (edges > m) {
            return 0; // No need to continue if edges exceed m
        }

        visited.add(src);
        int routes = 0;

        for (Edge edge : graph) {
            if (edge.getX() == src && !visited.contains(edge.getY())) {
                routes += countRoutesHelper(edge.getY(), dest, m, edges + 1, visited);
            }
        }

        visited.remove(src);
        return routes;
    }

    /**
     * Main method to test the Q1B class.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        ArrayList<Edge> graph = new ArrayList<>();
        graph.add(new Edge(0, 6));
        graph.add(new Edge(0, 1));
        graph.add(new Edge(1, 6));
        graph.add(new Edge(1, 9));
        graph.add(new Edge(1, 5));
        graph.add(new Edge(5, 3));
        graph.add(new Edge(3, 4));
        graph.add(new Edge(9, 5));
        graph.add(new Edge(9, 3));
        graph.add(new Edge(9, 4));
        graph.add(new Edge(6, 9));
        graph.add(new Edge(7, 6));
        graph.add(new Edge(7, 1));

        Q1B q1b = new Q1B(graph);
        int src = 0;
        int dest = 3;
        int m = 4;
        int routes = q1b.countRoutes(src, dest, m);
        System.out.println("Total number of routes with exactly " + m + " edges: " + routes);
    }
}
