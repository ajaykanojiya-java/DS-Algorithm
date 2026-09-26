package practiceset.graph;

import java.util.ArrayList;

/*
Given a two-dimensional grid of 0s and 1s, find the size of the largest island. If there is no island return 0.

An island is a group of 1s connected vertically or horizontally.

Example One
{
"grid": [
[1, 1, 0],
[1, 1, 0],
[0, 0, 1]
]
}
Output:

4
 */
public class FindLargestIsland {

    public static void main(String[] args) {

        ArrayList <ArrayList<Integer>> grid = new ArrayList<>();
        grid.add(new ArrayList<Integer>() {{ add(1); add(1); add(0); }});
        grid.add(new ArrayList<Integer>() {{ add(1); add(1); add(0); }});
        grid.add(new ArrayList<Integer>() {{ add(0); add(0); add(1); }});

        System.out.println("Result "+max_island_size(grid));
    }

    //Function to find the size of the largest island in the grid
    static Integer max_island_size(ArrayList<ArrayList<Integer>> grid) {
        int n = grid.size();
        int m = grid.get(0).size();
        boolean [][] visited = new boolean[n][m];
        int count = 0;
        int maxIslandSize = 0;
        for(int i=0;i<n;i++){
            for(int j=0; j<m; j++){
                //if the cell is land and not visited, perform DFS to find the size of the island
                if(grid.get(i).get(j) == 1 && !visited[i][j]){
                    count = dfs(i,j,grid,visited);
                    maxIslandSize = Math.max(count,maxIslandSize);
                }
            }
        }
        return maxIslandSize;
    }

    //DFS function to explore the island and calculate its size
    static int dfs(int row, int col, ArrayList<ArrayList<Integer>> grid, boolean [][] visited){
        //direction array
        int [] dr = {-1,0,0,1};
        int [] dc = {0,-1,1,0};
        int n = grid.size();
        int m = grid.get(0).size();

        //base condition
        if(row<0 || row>=n || col<0 || col>=m || grid.get(row).get(col) == 0 || visited[row][col]){
            return 0;
        }

        //mark the vertex visited
        visited[row][col] = true;
        int size = 1;

        //explore the neighbors
        for(int k=0; k<4; k++){
            int newRow = dr[k] + row;
            int newCol = dc[k] + col;
            size += dfs(newRow,newCol,grid,visited);
        }
        return size;
    }

}
