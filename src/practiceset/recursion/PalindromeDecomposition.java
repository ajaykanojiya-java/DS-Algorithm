package practiceset.recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromeDecomposition {

    public static void main(String[] args) {

        String s = "aba";

        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);

        System.out.println(result);
    }

    static void backtrack(String s, int start, List<String> path, List<String> result) {

        /*
         * Base Case:
         * If we reached end of string, we found one valid decomposition
         */
        if (start == s.length()) {

            // Join using "|"
            result.add(String.join("|", path));
            return;
        }

        /*
         * Try all possible substrings starting from 'start'
         */
        for (int end = start; end < s.length(); end++) {

            String substring = s.substring(start, end + 1);

            /*
             * Check if substring is palindrome
             */
            if (isPalindrome(substring)) {

                // Choose
                path.add(substring);

                // Explore
                backtrack(s, end + 1, path, result);

                // Backtrack (remove last choice)
                path.remove(path.size() - 1);
            }
        }
    }

    /*
     * Helper function to check palindrome
     */
    static boolean isPalindrome(String str) {

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
