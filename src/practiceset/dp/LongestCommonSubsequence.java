package practiceset.dp;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println(lcs(s1, s2));
    }

    static String lcs(String a, String b) {
        // Write your code here.

        String [][] memo = new String[a.length()][b.length()];
        String result = helper(a, b, 0, 0,memo);
        return result.isEmpty() ? "-1" : result;

    }

    static String helper(String a, String b, int i, int j,String[][] memo){

        //terminal case
        if((i == a.length())|| (j == b.length()))
            return "";

        if(memo[i][j] != null)
            return memo[i][j];

        //if char matches
        if(a.charAt(i) == b.charAt(j)){
            memo[i][j] =  a.charAt(i) + helper(a,b,i+1,j+1,memo);
            return memo[i][j];

        }

        //if char are not mached
        //move one char forward in a
        String s1 = helper(a,b,i+1,j,memo);

        //move one char forward in b
        String s2 = helper(a,b,i,j+1,memo);

        memo[i][j] = (s1.length()>s2.length())? s1:s2;

        return memo[i][j];
    }
}
