package practiceset.graph;

/*
Count Islands
Given a two-dimensional matrix of 0s and 1s, find the number of islands.
An island is a group of connected 1s or a standalone 1. A cell in the matrix can be connected to up to 8 neighbors: 2 vertical, 2 horizontal and 4 diagonal.

Example
{
"matrix": [
[1, 1, 0, 0, 0],
[0, 1, 0, 0, 1],
[1, 0, 0, 1, 1],
[0, 0, 0, 0, 0],
[1, 0, 1, 0, 1]
]
suppose we are stading at cell (i,j) in the matrix, then the 8 neighbors of (i,j) are:
      (i-1,j-1)  (i-1,j)  (i-1,j+1)
      ( i ,j-1)   (i,j)   ( i ,j+1)
      (i+1,j-1)  (i+1,j)  (i+1,j+1)
 */
public class NumberOfIslands8Direction {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };

        System.out.println(countIslands(matrix));
    }

    static int countIslands(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int count = 0;

        // Create a visited array to keep track of visited cells
        boolean [][] visited = new boolean[n][m];

        // Traverse the matrix and perform DFS for each unvisited land cell
        for(int i=0;i<n; i++){
            for(int j=0;j<m; j++){
                if(matrix[i][j] == 1 && !visited[i][j]){
                    dfs(matrix, i, j, visited, n, m);
                    count++;
                }
            }
        }
        return count;
    }

    static void dfs(int[][] matrix, int i, int j, boolean[][] visited, int n, int m) {

        int rows[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int cols[] = {-1, 0, 1, -1, 1, -1, 0, 1};

        // Check if the current cell is out of bounds or already visited or water
        if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || matrix[i][j] == 0) {
            return;
        }

        // Mark the current cell as visited
        visited[i][j] = true;

        // Explore all 8 neighbors
        for(int k=0; k<8; k++){
            int newRow = i+rows[k];
            int newCol = j+cols[k];
            dfs(matrix, newRow, newCol, visited, n, m);

        }
        // Explore all 8 neighbors
        /*dfs(matrix, i - 1, j - 1, visited, n, m);
        dfs(matrix, i - 1, j, visited, n, m);
        dfs(matrix, i - 1, j + 1, visited, n, m);
        dfs(matrix, i, j - 1, visited, n, m);
        dfs(matrix, i, j + 1, visited, n, m);
        dfs(matrix, i + 1, j - 1, visited, n, m);
        dfs(matrix, i + 1, j, visited, n, m);
        dfs(matrix, i + 1, j + 1, visited, n, m);*/
    }
}
