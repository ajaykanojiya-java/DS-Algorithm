package practiceset.recursion.set02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Given a seven-digit phone number, return all the character combinations that can be generated according to the following mapping:
Graph
Return the combinations in the lexicographical order.
Example One
{
"phone_number": "1234567"
}
Output:
["adgjmp","adgjmq","adgjmr","adgjms","adgjnp","cfilns","cfilop","cfiloq","cfilor","cfilos"]
First string "adgjmp" in the first line comes from the first characters mapped to digits 2, 3, 4, 5, 6 and 7 respectively. Since digit 1 maps to nothing, nothing is appended before 'a'. Similarly, the fifth string "adgjnp" generated from first characters of 2, 3, 4, 5 second character of 6 and first character of 7. All combinations generated in such a way must be returned in the lexicographical order.
 */
public class WordsFromPhoneNumber {

    public static void main(String[] args) {

        String digits = "12345678";
        ArrayList<String> result = get_words_from_phone_number(digits);
        System.out.println(result);
    }

    //Time Complexity: O(4^n) where n is the number of digits in the phone number. In the worst case, each digit can map to 4 letters (like digit 7 or 9), leading to 4^n combinations.
    //Space Complexity: O(n) for the recursion stack, where n is the number of digits in the phone number. The space used to store the result is not counted in this complexity analysis
    static ArrayList<String> get_words_from_phone_number(String phone_number) {
        // Write your code here.
        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        ArrayList<String> result = new ArrayList<>();
        phone_number = phone_number.replace("0","").replace("1","");
        if(phone_number.length() == 0){
            result.add("");
            return result;
        }

        helper(phone_number,phoneMap,0,new StringBuilder(),result);
        return result;
    }

    static void helper(String phone_number, Map<Character,String> phoneMap, int index, StringBuilder slate, ArrayList<String> result){

        //base case
        if(index == phone_number.length()){
            result.add(slate.toString());
            return;
        }

        String letters = phoneMap.get(phone_number.charAt(index));

        for(char letter: letters.toCharArray()){
            slate.append(Character.toString(letter));//include path
            helper(phone_number,phoneMap,index+1,slate,result);//explore deeper
            slate.deleteCharAt(index);//backtrack
        }
    }
}
