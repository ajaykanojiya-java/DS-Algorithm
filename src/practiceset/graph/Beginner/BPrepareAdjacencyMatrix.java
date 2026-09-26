package practiceset.graph.Beginner;

import java.util.ArrayList;
import java.util.List;

/*
what is adjacency matrix?
An adjacency matrix is a square matrix used to represent a finite graph. The elements of the matrix indicate whether
pairs of vertices are adjacent or not in the graph. In an adjacency matrix, the rows and columns represent the vertices
of the graph, and the entries in the matrix are typically 0 or 1 (or sometimes weights for weighted graphs).
example:
For a graph with 5 vertices (0, 1, 2, 3, 4) and the following edges:
0 - 1
1 - 4
1 - 2
1 - 3
3 - 4
The adjacency matrix representation would look like this:
    0 1 2 3 4
0 [0 1 0 0 0]
1 [1 0 1 1 1]
2 [0 1 0 0 0]
3 [0 1 0 0 1]
4 [0 1 0 1 0]
 */
public class BPrepareAdjacencyMatrix {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(List.of(0, 1)));
        edges.add(new ArrayList<>(List.of(1, 4)));
        edges.add(new ArrayList<>(List.of(1, 2)));
        edges.add(new ArrayList<>(List.of(1, 3)));
        edges.add(new ArrayList<>(List.of(3, 4)));
        ArrayList<ArrayList<Integer>> adjMatrix = convert_edge_list_to_adjacency_matrix(5, edges);
        System.out.println(adjMatrix);
    }

    // Convert edge list to adjacency matrix
    //Time Complexity: O(n^2 + e), where n is the number of vertices and e is the number of edges. Initializing the adjacency matrix takes O(n^2) time
    //Space Complexity: O(n^2), where n is the number of vertices. The adjacency matrix representation requires O(n^2) space.
    public static ArrayList<ArrayList<Integer>> convert_edge_list_to_adjacency_matrix(Integer n, ArrayList<ArrayList<Integer>> edges) {
        // Initialize adjacency matrix
        ArrayList<ArrayList<Integer>> adjMatrix = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(0);
            }
            adjMatrix.add(list);
        }

        // Add edges in both directions because graph is undirected
        for (ArrayList<Integer> edge : edges) {
            int src = edge.get(0);
            int dest = edge.get(1);

            adjMatrix.get(src).set(dest, 1);
            adjMatrix.get(dest).set(src, 1);
        }

        return adjMatrix;
    }
}
