package practiceset.string;

public class DPalindromTwoPointer {
    public static void main(String[] args) {
        String string = "madaadam";
        System.out.println("Is Palindrome "+isPalindrome(string));
    }

    //Time:  O(n)
    //Space: O(1)
    private static boolean isPalindrome(String s) {
        int right = s.length()-1;
        int left = 0;
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
