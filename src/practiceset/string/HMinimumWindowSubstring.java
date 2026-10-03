package practiceset.string;

public class HMinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println("SubString "+minWindowSubString(s,t));
    }

    private static String minWindowSubString(String s, String t){
        if(s.isEmpty() || t.isEmpty() || s.length()<t.length())
            return "";

        int [] freq = new int[26];

        for(char c : t.toCharArray())
            freq[c-'A']++;

        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int required = t.length();
        int startIndex = 0;

        while(right < s.length()){
            char ch = s.charAt(right);

            // If this character is still required
            if(freq[ch-'A'] > 0)
                required--;

            freq[ch-'A']--;

            while(required == 0){
                char leftChar = s.charAt(left);
                int windowLength = right - left + 1;
                if(windowLength < minLength){
                    minLength = windowLength;
                    startIndex = left;
                }

                freq[leftChar-'A']++;

                if(freq[leftChar-'A'] > 0)
                    required++;


                left++;
            }
            right++;
        }
        return s.substring(startIndex,startIndex + minLength);
    }
}
