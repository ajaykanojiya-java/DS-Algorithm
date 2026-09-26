package practiceset.graph.Beginner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ECountConnectedComponent {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(java.util.List.of(0, 1)));
        edges.add(new ArrayList<>(java.util.List.of(0, 2)));
        edges.add(new ArrayList<>(java.util.List.of(1, 2)));
        edges.add(new ArrayList<>(java.util.List.of(3, 4)));

        Integer n = 5; // Number of vertices
        Integer components = number_of_connected_components(n, edges);
        System.out.println(components);
    }

    static Integer number_of_connected_components(Integer n, ArrayList<ArrayList<Integer>> edges) {

        Set<Integer> visited = new HashSet<>();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(!visited.contains(i)) {
                dfs(i, adjList, visited);
                count++;
            }
        }
       return count;
    }

    public static void dfs(Integer i, ArrayList<ArrayList<Integer>> adjList, Set<Integer> visited){
        visited.add(i);
        for(Integer neighbour : adjList.get(i)){
            if(!visited.contains(neighbour)){
                dfs(neighbour, adjList, visited);
            }
        }
    }
}

