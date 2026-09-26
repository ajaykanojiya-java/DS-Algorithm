package practiceset.graph.Beginner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/*
what is DFS traversal?
Depth-First Search (DFS) is an algorithm for traversing or searching tree or graph data structures.
It starts at the root (or an arbitrary node in the case of a graph) and explores as far as possible along each branch before backtracking.
 */
public class DDFSTraversal {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(java.util.List.of(0, 1)));
        edges.add(new ArrayList<>(java.util.List.of(0, 2)));
        edges.add(new ArrayList<>(java.util.List.of(0, 4)));
        edges.add(new ArrayList<>(java.util.List.of(2, 3)));

        Integer n = 6; // Number of vertices
        ArrayList<Integer> dfsResult = dfs_traversal(n, edges);
        System.out.println(dfsResult);
    }

    //Time Complexity: O(n + e), where n is the number of vertices and e is the number of edges. Each vertex and edge is processed once.
    //Space Complexity: O(n + e), where n is the number of vertices and e is the number of edges. The adjacency list representation
    // requires O(n + e) space, and the visited set and recursion stack also require O(n) space in the worst case.
    static ArrayList<Integer> dfs_traversal(Integer n, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }

        //create adjList
        for(ArrayList<Integer> edge: edges){
            int src = edge.get(0);
            int dest = edge.get(1);

            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }

        Set<Integer> visited = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();

        //Traverse the graph using DFS
        for(int i=0;i<n; i++){
            if(!visited.contains(i))
                dfs(i, visited, result, adjList);
        }

        return result;
    }

    // Perform DFS traversal from a given source node
    public static void dfs(Integer n, Set<Integer> visited, ArrayList<Integer> result,
                           ArrayList<ArrayList<Integer>> adjList){

        visited.add(n);
        result.add(n);

        // Traverse all the neighbors of the current node
        for(Integer node : adjList.get(n)){
            if(!visited.contains(node))
                //Recursively call dfs for unvisited neighbors
                dfs(node, visited, result, adjList);
        }
    }
}
