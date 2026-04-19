package practiceset.graph;

//Input: V = 5, edges[][] = [[0, 1], [2, 1], [3, 4]]
//Output: [[0, 1, 2], [3, 4]]

import java.util.*;

//Input: V = 7, edges[][] = [[0, 1], [6, 0], [2, 4], [2, 3], [3, 4]]
//Output: [[0, 1, 6], [2, 3, 4], [5]]
public class CountComponent {
    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {{0, 1}, {2, 1}, {3, 4}};

        // Convert the 2D array of edges to a List of Lists
        List<List<Integer>> edgesList = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            List<Integer> edge = new ArrayList<>();
            edge.add(edges[i][0]);
            edge.add(edges[i][1]);
            edgesList.add(edge);
        }
        System.out.println(edgesList);
        System.out.println(countComponents(V, edgesList));
    }

    static int countComponents(int V, List<List<Integer>> edges) {

        List<List<Integer>> adjList = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        int count = 0;

        // Initialize the adjacency list
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        // Build the adjacency list from the edges
        for (List<Integer> edge : edges) {
            int src = edge.get(0);
            int dest = edge.get(1);

            // Since the graph is undirected, add the destination to the source's list and the source to the destination's list
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }

        // Traverse the graph using DFS
        for (int i = 0; i < V; i++) {
            // If the node has not been visited, perform DFS and increment the count of components
            if (!visited.contains(i)) {
                dfs(i, adjList, visited);
                //bfs(i, adjList, visited);
                count++;
            }
        }
        return count;
    }

    // T(n) = O(V + E) where V is the number of vertices and E is the number of edges in the graph.
    static void dfs(int node, List<List<Integer>> adjList, Set<Integer> visited) {
        // Mark the current node as visited
        visited.add(node);

        // Explore all the neighbors of the current node
        for (Integer neighbor : adjList.get(node)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, adjList, visited);
            }
        }
    }

    static void bfs(int node, List<List<Integer>> adjList, Set<Integer> visited) {
        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited.add(node);

        // Traverse the graph using BFS
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            // Explore all the neighbors of the current node
            for (Integer neighbor : adjList.get(currentNode)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

}
