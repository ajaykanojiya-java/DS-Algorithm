package practiceset.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DetectCycle {

    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};

        // Convert the 2D array of edges to a List of Lists
        List<List<Integer>> edgesList = new ArrayList<>();
        // Loop through the edges array and convert each edge to a List<Integer>
        for (int i = 0; i < edges.length; i++) {
            List<Integer> edge = new ArrayList<>();
            edge.add(edges[i][0]);
            edge.add(edges[i][1]);
            edgesList.add(edge);
        }
        System.out.println(edgesList);
        System.out.println(detectCycle(V,edgesList));
    }

    private static boolean detectCycle(int V, List<List<Integer>> edgesList){
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        //initialize the adjacency list
        for(int i=0;i<V; i++){
            adjacencyList.add(new ArrayList<>());
        }

        //prepare the adjacencyList
        for(List<Integer> edge : edgesList){
            int src = edge.get(0);
            int dest = edge.get(1);

            adjacencyList.get(src).add(dest);
            adjacencyList.get(dest).add(src);

        }

        //traverse the graph
        for(int i=0;i<V;i++){
            if(!visited.contains(i)){
                if(dfs(i,-1,adjacencyList,visited))
                    return true;
            }
        }
        return false;
    }

    private static boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adjacencyList, Set<Integer> visited){

        //mark the current node as visited
        visited.add(node);

        for(int neighbour : adjacencyList.get(node)){
            if(!visited.contains(neighbour)){
                if(dfs(neighbour,node,adjacencyList,visited))
                    return true;
            }
            else if(neighbour != parent)
                return true;
        }
        return false;
    }

}
