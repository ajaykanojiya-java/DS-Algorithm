package practiceset.string;

public class IStringCompression {
    public static void main(String[] args) {
        String input = "aabcccccaaa";
        System.out.println("Compressed string: " + compressString(input));
        //output: a2b1c5a3
    }

    //Time complexity: O(n), where n is the length of the input string
    //Space complexity: O(n), where n is the length of the input string
    private static String compressString(String s){

        StringBuilder result = new StringBuilder();

        int count = 1;
        for(int i=1;i<=s.length();i++){
            if(i<s.length() && s.charAt(i-1) == s.charAt(i)){
                count++;
            }else{
                result.append(s.charAt(i-1)).append(count);
                count = 1;
            }
        }
        return result.toString();
    }
}
