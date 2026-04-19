package practiceset.recursion;

import java.util.ArrayList;

public class TowerOfHanoi {

    public static void main(String[] args) {
        Integer n = 3;
        ArrayList<ArrayList<Integer>> result = tower_of_hanoi(n);
        for (ArrayList<Integer> move : result) {
            System.out.println(move);
        }
    }

    /*
     * Asymptotic complexity in terms of `n`:
     * Time: O(2^n).
     * Auxiliary space: O(n).
     * Total space: O(2^n).
     */

    static ArrayList<ArrayList<Integer>> tower_of_hanoi(Integer n) {
        // Write your code here
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        tower_of_hanoi_util(n, 1, 3, 2, answer);
        return answer;
    }

    public static void tower_of_hanoi_util(int n, int from_peg,
                                           int to_peg, int aux_peg, ArrayList<ArrayList<Integer>> answer) {

        // If reached at condition when n equal to one.
        if (n == 1) {
            // As it is last disk we shift it from from_peg to to_peg
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(from_peg);
            temp.add(to_peg);
            answer.add(temp);
            return;
        }
        // Call the function to shift top n - 1 disks from from_peg to aux_peg using to_peg.
        tower_of_hanoi_util(n - 1, from_peg, aux_peg, to_peg, answer);

        // Store the step of moving of 1 top disk from from_peg to to_peg
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(from_peg);
        temp.add(to_peg);
        answer.add(temp);

        // Shifting back remaining n - 1 disks from aux_peg to to_peg using from_peg
        tower_of_hanoi_util(n - 1, aux_peg, to_peg, from_peg, answer);
    }

}
