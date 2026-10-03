package practiceset.string;

public class AAnagram {
    public static void main(String[] args) {
        String s = "silent";
        String t = "listen";

        System.out.println("IS anagram: "+isAnagram(s,t));
    }

    //Time:  O(n)
    //Space: O(1)
    private static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        int [] sCount = new int[26];
        int [] pCount = new int[26];

        for(int i=0;i<s.length();i++){
            sCount[s.charAt(i)-'a']++;
            pCount[t.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(sCount[i] != pCount[i])
                return false;
        }
        return true;
    }
}
