package practiceset.string;

public class CFirstNonRepeatingChar {
    public static void main(String[] args) {
        String s = "swiss";
        System.out.println("First Non Repeating char "+findNonRepeatingChar(s));
    }

    //Time:  O(n)
    //Space: O(1)
    private static char findNonRepeatingChar(String s) {
        int [] freq = new int[26];

        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }

        for(char c: s.toCharArray()){
            if(freq[c-'a'] == 1)
                return c;
        }
        return '\0';
    }
}
