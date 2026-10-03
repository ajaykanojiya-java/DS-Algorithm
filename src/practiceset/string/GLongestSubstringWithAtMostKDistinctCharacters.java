package practiceset.string;

import java.util.HashMap;

public class GLongestSubstringWithAtMostKDistinctCharacters {
    public static void main(String[] args) {
        String s = "ecceba";
        int k = 2;
        System.out.println("Length of longest substring with at most " + k + " distinct characters: " + longestSubstring(s, k));
    }

    //Time Complexity: O(n)
    //space Complexity: O(min(m, k)) where m is the size of the string
    private static int longestSubstring(String s, int k) {

        HashMap<Character,Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        // Use two pointers to maintain a sliding window
        for(int right=0;right<s.length();right++){
            char c = s.charAt(right);
            map.put(c,map.getOrDefault(c,0)+1);

            // Shrink the window if there are more than k distinct characters
            while(map.size()>k){
                char temp = s.charAt(left);
                map.put(temp,map.get(temp)-1);

                // Remove the character from the map if its count becomes zero
                if(map.get(temp) == 0)
                    map.remove(temp);
                left++;
            }
            maxLength = Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }
}
