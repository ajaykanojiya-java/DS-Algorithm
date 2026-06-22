package practiceset.recursion.set01;

/*
    * Given an integer A, how many structurally unique BST's (binary search trees) that store values 1...A?
    * Input Format
    * The first and the only argument of input contains an integer A.
    * Output Format
    * Return an integer, representing the number of structurally unique BST's which has exactly A nodes of unique values from 1 to A.
    * Constraints
    * 1 <= A <= 18
    * Example :
    * Input 1:
    *     A = 3
    * Output 1:
    *     5
    * Explanation 1:
    *     The 5 unique BSTs are:
    *
    *        1         3     3      2      1
    *         \       /     /      / \      \
    *          3     2     1      1   3      2
    *         /     /       \                 \
    *        2     1         2                 3
 */
public class HowManyBinarySearchTreesWithNNodes {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(countBST(n));
    }
    
    static Long countBST(int n) {
        // Base case: If there are 0 or 1 nodes, there is only one unique BST (the empty tree or a single node).
        if(n <= 1)
            return 1L;
        Long ans = 0L;
        // Recursive case: For each number i from 1 to n, consider it as the root of the BST.
        // The left subtree will have (i-1) nodes and the right subtree will have (n-i) nodes.
        // The total number of unique BSTs with i as the root is the product of the number of unique BSTs in the left and right subtrees.
        for(int i=1;i<=n;i++){
            ans = ans + (countBST(i-1) * countBST(n-i));
        }
        return ans;
    }
}
