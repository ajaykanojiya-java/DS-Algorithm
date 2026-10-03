package practiceset.string;

import java.util.HashSet;
import java.util.Set;

//sliding window
public class FLongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abadcbaefabcd";
        System.out.println("Longest Substring Length "+longestSubstring(s));
    }

    // Find the length of the longest substring without repeating characters
    //Time Complexity: O(n), Space Complexity: O(min(m,n)) where m is the size of the character set
    private static int longestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int right = 0;
        int left = 0;
        int maxLength = 0;

        //sliding window approach
        while(right <s.length()){
            char c = s.charAt(right);
            while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            maxLength = Math.max(maxLength, right-left+1);
            right++;
        }
        return maxLength;
    }
}
