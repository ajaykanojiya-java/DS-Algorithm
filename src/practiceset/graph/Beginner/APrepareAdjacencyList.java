package practiceset.graph.Beginner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
what is adjacency list?
An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of
neighbors of a vertex in the graph.
example:
For a graph with 5 vertices (0, 1, 2, 3, 4) and the following edges:
0 - 1
1 - 4
1 - 2
1 - 3
3 - 4
The adjacency list representation would look like this:
0: 1
1: 0, 2, 3, 4
2: 1
3: 1, 4
4: 1, 3
 */
public class APrepareAdjacencyList {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(List.of(0, 1)));
        edges.add(new ArrayList<>(List.of(1, 4)));
        edges.add(new ArrayList<>(List.of(1, 2)));
        edges.add(new ArrayList<>(List.of(1, 3)));
        edges.add(new ArrayList<>(List.of(3, 4)));
        ArrayList<ArrayList<Integer>> adjList = convert_edge_list_to_adjacency_list(5, edges);
        System.out.println(adjList);
    }

    // Convert edge list to adjacency list
    //Time Complexity: O(n + e log e), where n is the number of vertices and e is the number of edges. The sorting step takes O(e log e) time.
    //Space Complexity: O(n + e), where n is the number of vertices and e is the number of edges. The adjacency list representation requires O(n + e) space.
    static ArrayList<ArrayList<Integer>> convert_edge_list_to_adjacency_list(Integer n, ArrayList<ArrayList<Integer>> edges) {

        if(n.equals(0)) {
            return new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add edges in both directions because graph is undirected
        for (ArrayList<Integer> edge : edges) {
            int src = edge.get(0);
            int dest = edge.get(1);

            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }

        // Sort neighbors
        for (ArrayList<Integer> neighbors : adjList) {
            Collections.sort(neighbors);
        }

        return adjList;
    }
}
