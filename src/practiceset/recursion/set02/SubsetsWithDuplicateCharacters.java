package practiceset.recursion.set02;

import java.util.ArrayList;
import java.util.HashSet;

public class SubsetsWithDuplicateCharacters {
    public static void main(String[] args) {

        String s = "aab";
        System.out.println(get_distinct_subsets(s));
    }
    static ArrayList<String> get_distinct_subsets(String s) {
        ArrayList<String> result = new ArrayList<>();
        helper(s,0,new StringBuilder(),result, new HashSet<String>());

        return result;
    }

    static void helper(String s, int index, StringBuilder slate, ArrayList<String> result, HashSet<String> unique){

        //base case
        if(index == s.length()){
            if(unique.add(slate.toString()))
                result.add(slate.toString());
            return;
        }

        //include path
        slate.append(s.charAt(index));
        helper(s,index+1,slate,result,unique);
        slate.deleteCharAt(slate.length()-1);

        //exclude path
        //slate.append(s.charAt(index));
        helper(s,index+1,slate,result,unique);
    }
}
