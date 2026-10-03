package practiceset.string;

import java.util.ArrayList;

public class BFindAllAnagramsInAString {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println("All Anagram "+findAllAnagram(s,p));
    }

    //Time Complexity: O(n), Space Complexity: O(1)
    private static ArrayList<Integer> findAllAnagram(String s, String p) {
        ArrayList<Integer> result = new ArrayList<>();
        if(s.isEmpty() || p.isEmpty() || p.length() > s.length())
            return result;

        int [] sfreq = new int[26];
        int [] pfreq = new int[26];

        for(int i=0;i<p.length();i++){
            sfreq[s.charAt(i)-'a']++;
            pfreq[p.charAt(i)-'a']++;
        }

        if(match(sfreq,pfreq)){
            result.add(0);
        }

        int left = 0;
        for(int right = p.length();right < s.length();right++){
            //update freq for the char coming in
            sfreq[s.charAt(right)-'a']++;
            //update freq for the char going out
            sfreq[s.charAt(left)-'a']--;

            if(match(sfreq,pfreq))
                result.add(left+1);
            left++;
        }
        return result;
    }

    private static boolean match(int[] sfreq, int [] pfreq){
        for(int i=0;i<sfreq.length;i++){
            if(sfreq[i] != pfreq[i])
                return false;
        }
        return true;
    }
}
