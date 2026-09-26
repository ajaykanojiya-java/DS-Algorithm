package practiceset.graph.Beginner;

import java.util.*;

/*
what is BFS traversal?
Breadth-First Search (BFS) is an algorithm for traversing or searching tree or graph data structures.
It starts at the tree root (or some arbitrary node of a graph, sometimes referred to as a 'search key') and explores
the neighbor nodes at the present depth prior to moving on to the nodes at the next depth level.
{
"n": 6,
"edges": [
[0, 1],
[0, 2],
[0, 4],
[2, 3]
]
}
Output:
[0, 1, 2, 4, 3, 5]
 */
public class CBFSTraversal {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(List.of(0, 1)));
        edges.add(new ArrayList<>(List.of(0, 2)));
        edges.add(new ArrayList<>(List.of(0, 4)));
        edges.add(new ArrayList<>(List.of(2, 3)));

        Integer n = 6; // Number of vertices
        ArrayList<Integer> bfsResult = bfs_traversal(n, edges);
        System.out.println(bfsResult);

    }

    //Time Complexity: O(n + e), where n is the number of vertices and e is the number of edges. Each vertex and edge is processed once.
    //Space Complexity: O(n + e), where n is the number of vertices and e is the number of edges.
    // The adjacency list representation requires O(n + e) space, and the visited set and queue also require O(n) space in the worst case.
    static ArrayList<Integer> bfs_traversal(Integer n, ArrayList<ArrayList<Integer>> edges) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        //Initialize adjList
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        //create adjList
        for(ArrayList<Integer> edge : edges){
            int src = edge.get(0);
            int dest = edge.get(1);

            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }

        Set<Integer> visited = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();

        //Travers the graph using bfs
        for(int i=0; i<n; i++){
            if(!visited.contains(i))
                bfs(i, visited, adjList, result);
        }

        return result;
    }

    // Perform BFS traversal from a given source node
    static void bfs(Integer src, Set<Integer> visited, ArrayList<ArrayList<Integer>> adjList,
                    ArrayList<Integer> result){
        // Initialize a queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        // Mark the source node as visited and enqueue it
        visited.add(src);
        queue.add(src);

        // Traverse the graph using BFS
        while(!queue.isEmpty()){
            Integer node = queue.poll();
            result.add(node);
            // Add all unvisited neighbors of the current node to the queue
            for(Integer currentNode : adjList.get(node)){
                // If the neighbor has not been visited, mark it as visited and enqueue it
                if(!visited.contains(currentNode)){
                    visited.add(currentNode);
                    queue.add(currentNode);
                }
            }
        }
    }
}
