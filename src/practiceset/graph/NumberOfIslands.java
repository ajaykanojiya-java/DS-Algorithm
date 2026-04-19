package practiceset.graph;

import java.util.HashSet;
import java.util.Set;

/*
* Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3*/
public class NumberOfIslands {
    public static void main(String[] args) {
        /*char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };*/
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(numIslands(grid));
    }

    static int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        // Create a visited array to keep track of visited cells
        boolean [][] visited = new boolean[n][m];

        // Traverse the grid and perform DFS for each unvisited land cell
        for(int i=0;i<n; i++){
            for(int j=0;j<m; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(grid, i, j, visited, n, m);
                    count++;
                }
            }
        }
        return count;
    }

    // T(n) = O(n*m) where n is the number of rows and m is the number of columns in the grid. We are processing each cell once.
    static void dfs(char[][] grid, int i, int j, boolean [][] visited, int n, int m){

        //base case
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j] == '0' || visited[i][j]){
            return;
        }

        //mark the cell as visited
        visited[i][j] = true;

        //process left node
        dfs(grid, i, j-1, visited, n, m);

        //process right node
        dfs(grid, i, j+1, visited, n, m);

        //process top node
        dfs(grid, i-1, j, visited, n, m);

        //process bottom node
        dfs(grid, i+1, j, visited, n, m);
    }
}
