package practiceset.string;

public class EValidPalindromeWithCharactersIgnored {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println("Is Palindrome "+isPalindrome(s));
    }

    //Time Complexity: O(n), Space Complexity: O(1)
    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while(left < right){
            while(!Character.isLetter(s.charAt(left)))
                left++;
            while(!Character.isLetter(s.charAt(right)))
                right--;

            if(Character.toLowerCase(s.charAt(left))!= Character.toLowerCase(s.charAt(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
