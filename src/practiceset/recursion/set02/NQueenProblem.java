package practiceset.recursion.set02;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer n, find all possible ways to position n queens on an n×n chessboard so that no two queens attack each other.
A queen in chess can move horizontally, vertically, or diagonally.
Do solve the problem using recursion first even if you see some non-recursive approaches.
Example One
"n": 4
Output:[
["--q-",
 "q---",
 "---q",
 "-q--"],

["-q--",
 "---q",
 "q---",
 "--q-"]
]
 */
public class NQueenProblem {

    public static void main(String[] args) {

        List<List<String>> ans = solveNQueens(4);

        for (List<String> board : ans) {
            for (String row : board)
                System.out.println(row);
            System.out.println();
        }
    }

    public static List<List<String>> solveNQueens(int n) {

        List<Integer> slate = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        helper(n, 0, slate, result);
        return result;
    }

    static void helper(int n, int row, List<Integer> slate, List<List<String>> result) {

        // Backtracking
        if (!isValid(slate)) {
            return;
        }

        // Base case
        if (row == n) {
            result.add(createSolution(n, slate));
            return;
        }

        // Try every column
        for (int col = 0; col < n; col++) {

            // choose
            slate.add(col);

            // explore
            helper(n, row + 1, slate, result);

            // unchoose
            slate.remove(slate.size() - 1);
        }
    }

    static boolean isValid(List<Integer> slate) {

        int lastRow = slate.size() - 1;
        for (int prevRow = 0; prevRow < lastRow; prevRow++) {

            // Same column
            if (slate.get(lastRow).equals(slate.get(prevRow)))
                return false;

            int rowDiff = Math.abs(lastRow - prevRow);
            int colDiff = Math.abs(slate.get(lastRow) - slate.get(prevRow));

            // Same diagonal
            if (rowDiff == colDiff)
                return false;
        }
        return true;
    }

    static List<String> createSolution(int n, List<Integer> slate) {

        List<String> board = new ArrayList<>();

        for (int row = 0; row < n; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < n; col++) {
                if (slate.get(row) == col)
                    sb.append('Q');
                else
                    sb.append('.');
            }
            board.add(sb.toString());
        }
        return board;
    }

}
