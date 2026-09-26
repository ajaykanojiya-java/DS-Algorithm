package practiceset.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// A valid tree is a connected graph without cycles. In other words, a tree is a connected acyclic graph. A tree with N nodes must have exactly N-1 edges. If the number of edges is not equal to N-1, then the graph cannot be a tree. Additionally, we need to check if the graph is connected and does not contain any cycles.
// The following code checks if the given graph is a valid tree by verifying these conditions.
//Time Complexity: O(N + E), where N is the number of nodes and E is the number of edges. We traverse all nodes and edges once.
//space Complexity: O(N + E), for storing the adjacency list and the visited set.
public class IsValidTree {
    public static void main(String[] args) {
        Integer nodeCount = 4;

        ArrayList<Integer> edgeStart = new ArrayList<>();
        ArrayList<Integer> edgeEnd = new ArrayList<>();

        edgeStart.add(0);
        edgeEnd.add(1);

        edgeStart.add(1);
        edgeEnd.add(2);

        edgeStart.add(0);
        edgeEnd.add(3);

        System.out.println(is_it_a_tree(nodeCount, edgeStart, edgeEnd));
    }

    // Function to check if the given graph is a valid tree
    // A valid tree must satisfy two conditions:
    // 1. It must be connected (all nodes are reachable from any node).
    // 2. It must not contain any cycles.
    static Boolean is_it_a_tree(Integer nodeCount,ArrayList<Integer> edgeStart,ArrayList<Integer> edgeEnd) {

        // A tree with N nodes must have exactly N-1 edges.
        if (edgeStart.size() != nodeCount - 1) {
            return false;
        }

        // Build adjacency list.
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < nodeCount; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeStart.size(); i++) {
            int src = edgeStart.get(i);
            int dest = edgeEnd.get(i);
            adjacencyList.get(src).add(dest);
            adjacencyList.get(dest).add(src);
        }

        Set<Integer> visited = new HashSet<>();
        // Detect cycle.
        if (dfs(0, -1, adjacencyList, visited)) {
            return false;
        }
        // Check if all nodes are connected.
        return visited.size() == nodeCount;
    }

    // Depth-First Search to detect cycle in an undirected graph.
    private static boolean dfs(int node,int parent, ArrayList<ArrayList<Integer>> adjacencyList, Set<Integer> visited) {

        visited.add(node);
        // Traverse all the neighbors of the current node.
        for (int neighbour : adjacencyList.get(node)) {
            if (!visited.contains(neighbour)) {
                // If the neighbor hasn't been visited, recursively call dfs on it.
                if (dfs(neighbour, node, adjacencyList, visited)) {
                    return true;
                }
            } else if (neighbour != parent) {
                // If the neighbor is visited and is not the parent, a cycle is detected.
                return true;
            }
        }
        return false;
    }
}
