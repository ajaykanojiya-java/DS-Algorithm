package practiceset.recursion.set02;

import java.util.ArrayList;

/*
Given a partially filled two-dimensional array, fill all the unfilled cells such that each row, each column and each 3 x 3 subgrid
has every digit from 1 to 9 exactly once. Unfilled cells have a value of 0 on the given board.
 */
public class SudokuSolver {
    public static void main(String[] args) {
        ArrayList <ArrayList<Integer>> board = new ArrayList<>();
        board.add(new ArrayList<Integer>() {{add(5); add(3); add(0); add(0); add(7); add(0); add(0); add(0); add(0);}});
        board.add(new ArrayList<Integer>() {{add(6); add(0); add(0); add(1); add(9); add(5); add(0); add(0); add(0);}});
        board.add(new ArrayList<Integer>() {{add(0); add(9); add(8); add(0); add(0); add(0); add(0); add(6); add(0);}});
        board.add(new ArrayList<Integer>() {{add(8); add(0); add(0); add(0); add(6); add(0); add(0); add(0); add(3);}});
        board.add(new ArrayList<Integer>() {{add(4); add(0); add(0); add(8); add(0); add(3); add(0); add(0); add(1);}});
        board.add(new ArrayList<Integer>() {{add(7); add(0); add(0); add(0); add(2); add(0); add(0); add(0); add(6);}});
        board.add(new ArrayList<Integer>() {{add(0); add(6); add(0); add(0); add(0); add(0); add(2); add(0); add(0);}});
        board.add(new ArrayList<Integer>() {{add(0); add(0); add(0); add(4); add(1); add(9); add(0); add(0); add(5);}});
        board.add(new ArrayList<Integer>() {{add(0); add(0); add(0); add(0); add(8); add(0); add(0); add(7); add(9);}});
        solve_sudoku_puzzle(board);
        printBoard(board);
    }

    static ArrayList<ArrayList<Integer>> solve_sudoku_puzzle(ArrayList<ArrayList<Integer>> board) {

        solveSudoku(board);

        return board;
    }

    // Backtracking approach
    static boolean solveSudoku(ArrayList<ArrayList<Integer>> board) {
        // Find an empty cell
        for (int row = 0; row < 9; row++) {
            // Loop through columns
            for (int col = 0; col < 9; col++) {
                // If cell is empty
                if (board.get(row).get(col) == 0) {

                    // Try numbers 1-9
                    for (int num = 1; num <= 9; num++) {
                        // Check if number is valid in the current cell
                        if (isValid(board, row, col, num)) {

                            // Choose
                            board.get(row).set(col, num);

                            // Explore
                            if (solveSudoku(board)) {
                                return true;
                            }

                            // Backtrack
                            board.get(row).set(col, 0);
                        }
                    }

                    // No number works
                    return false;
                }
            }
        }

        // Entire board filled
        return true;
    }

    // Check if placing num in board[row][col] is valid
    static boolean isValid(ArrayList<ArrayList<Integer>> board,
                           int row,
                           int col,
                           int num) {

        // Check row
        for (int j = 0; j < 9; j++) {
            if (board.get(row).get(j) == num) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (board.get(i).get(col) == num) {
                return false;
            }
        }

        // Check 3x3 subgrid
        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;

        for (int i = boxRow; i < boxRow + 3; i++) {

            for (int j = boxCol; j < boxCol + 3; j++) {

                if (board.get(i).get(j) == num) {
                    return false;
                }
            }
        }

        return true;
    }

    // Utility function to print the Sudoku board
    static void printBoard(ArrayList<ArrayList<Integer>> board) {
        for (ArrayList<Integer> row : board) {
            for (Integer num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
