package practiceset.recursion.set02;

import java.util.ArrayList;
/*
Given a string of digits, generate all possible expressions by inserting the operators '+', '*', or no operator (concatenation) between the
digits such that the expression evaluates to a given target value.
*/
public class GenerateAllPossibleExpressions {

    public static void main(String[] args) {

        String s = "211";
        int target = 3;

        ArrayList<String> result = new ArrayList<>();

        helper(s,target,0,new StringBuilder(),0,0,result);

        System.out.println(result);
    }

    //Time Complexity: O(4^n) where n is the length of the input string s.
    // In the worst case, we may have to explore all possible combinations of the digits and operators.
    //space Complexity: O(n) where n is the length of the input string s.
    private static void helper(String s,long target, int index, StringBuilder expression, long runningSum, long lastOperand,
            ArrayList<String> result) {

        if (index == s.length()) {
            if (runningSum == target) {
                result.add(expression.toString());
            }
            return;
        }

        int originalLength = expression.length();
        long operand = 0;

        // Try every possible operand beginning at index:
        // "0", "02", "202", etc.
        for (int end = index; end < s.length(); end++) {
            operand = operand * 10 + (s.charAt(end) - '0');
            String operandText = s.substring(index, end + 1);

            if (index == 0) {
                expression.append(operandText);
                helper(s, target, end + 1, expression,operand, operand, result);
                expression.setLength(originalLength);
            } else {
                expression.append("+").append(operandText);
                helper(s, target, end + 1, expression,runningSum + operand, operand, result);
                expression.setLength(originalLength);


                expression.append("*").append(operandText);
                helper(s, target, end + 1, expression,runningSum - lastOperand + lastOperand * operand,
                        lastOperand * operand,result);
                expression.setLength(originalLength);
            }
        }
    }
}