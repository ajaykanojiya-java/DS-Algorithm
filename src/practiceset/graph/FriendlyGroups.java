package practiceset.graph;

import java.util.ArrayList;

/*
Friendly Groups
There are n people living in a town. Some of them dislike each other. Given the value of n and two equal length integer arrays called dislike1
and dislike2. For each i in [0, dislike1_size - 1], the person dislike1[i] dislikes the person dislike2[i].
Check if we can divide the people of the town into two sets such that each person belongs to exactly one set and no two persons disliking
each other belong to the same set.
Example One
{
"num_of_people": 5,
"dislike1": [0, 1, 1, 2, 3],
"dislike2": [2, 2, 4, 3, 4]
}
Output: 1
The people can be partitioned into two sets [0, 1, 3] and [2, 4].
bipartite graph: true; what is bipartite graph: A bipartite graph is a graph whose vertices can be divided into two disjoint sets such that
no two vertices within the same set are adjacent. In other words, it is a graph that can be colored using two colors in such a way that no
two adjacent vertices have the same color. If a graph is bipartite, it means that it can be divided into two sets where each edge connects
a vertex from one set to a vertex from the other set.
 */

//Time Complexity: O(V + E), where V is the number of people and E is the number of dislike pairs. We traverse all vertices and edges once.
//Space Complexity: O(V + E), for storing the adjacency list and the colored array.
public class FriendlyGroups {
    public static void main(String[] args) {
        Integer V = 5;
        ArrayList<Integer> dislike1 = new ArrayList<>();
        ArrayList<Integer> dislike2 = new ArrayList<>();

        dislike1.add(0);
        dislike1.add(1);
        dislike1.add(1);
        dislike1.add(2);
        dislike1.add(3);
        dislike2.add(2);
        dislike2.add(2);
        dislike2.add(4);
        dislike2.add(3);
        dislike2.add(4);

        System.out.println(can_be_divided(V, dislike1, dislike2));
    }

    static Boolean can_be_divided(Integer num_of_people, ArrayList<Integer> dislike1, ArrayList<Integer> dislike2) {

        if (dislike1.size() != dislike2.size()) {
            return false;
        }

        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        //initialize the adjacency list
        for (int i = 0; i < num_of_people; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        //prepare the adjacencyList
        for (int i = 0; i < dislike1.size(); i++) {
            int u = dislike1.get(i);
            int v = dislike2.get(i);
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        int[] colored = new int[num_of_people];

        //traverse the graph
        for (int i = 0; i < num_of_people; i++) {
            if (colored[i] == 0) {
                colored[i] = 1;
                //perform DFS to color the graph and check if it can be divided into two sets
                if (!dfs(i, adjacencyList, colored))
                    return false;
            }
        }
        return true;
    }

    //DFS function to color the graph and check if it can be divided into two sets
    static boolean dfs(int node, ArrayList<ArrayList<Integer>> adjancencyList, int[] colored) {

        //traverse all the neighbors of the current node
        for (int neighbour : adjancencyList.get(node)) {
            if (colored[neighbour] == 0) {
                colored[neighbour] = -colored[node];
                //
                if (!dfs(neighbour, adjancencyList, colored))
                    return false;
            } else if (colored[neighbour] == colored[node]) {
                return false;
            }
        }
        return true;
    }
}
