package practiceset.recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public static void main(String[] args) {
        String s = "a1Z";
        System.out.println(letter_case_permutation(s));
    }

    public static List<String> letter_case_permutation(String s){
        List<String> result = new ArrayList<>();
        helper(s, 0, new StringBuilder(), result);
        return result;
    }
    public static void helper(String s, int index, StringBuilder slate, List<String> result){
        if(index == s.length()){
            result.add(slate.toString());
            return;
        }

        char ch = s.charAt(index);
        if (Character.isLetter(ch)) {
            slate.append(Character.toUpperCase(ch));
            helper(s, index + 1, slate, result);
            slate.deleteCharAt(slate.length() - 1);

            slate.append(Character.toLowerCase(ch));
            helper(s, index + 1, slate, result);
            slate.deleteCharAt(slate.length() - 1);
        } else {
            slate.append(ch);
            helper(s, index + 1, slate, result);
            slate.deleteCharAt(slate.length() - 1);
        }
    }
}
