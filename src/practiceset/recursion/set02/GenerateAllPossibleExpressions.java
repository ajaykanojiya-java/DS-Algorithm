package practiceset.recursion.set02;

import java.util.ArrayList;

public class GenerateAllPossibleExpressions {

    public static void main(String[] args) {

        String s = "202";
        int target = 4;

        ArrayList<String> result = new ArrayList<>();

        helper(s,target,0,new StringBuilder(),0,0,result);

        System.out.println(result);
    }

    private static void helper(String s,int target, int index, StringBuilder expression, long runningSum,long lastOperand,
                               ArrayList<String> result) {

        // Base case
        if (index == s.length()) {
            if (runningSum == target) {
                result.add(expression.toString());
            }
            return;
        }

        int digit = s.charAt(index) - '0';

        // First number is special (no operator before it)
        if (index == 0) {
            expression.append(digit);
            helper(s,target,index + 1,expression,digit,digit,result);
            expression.setLength(expression.length() - 1);
            return;
        }

        int len = expression.length();

        // Add operator '+'
        expression.append("+").append(digit);
        helper(s,target,index + 1,expression,runningSum + digit, digit,result);
        expression.setLength(len);

        // Add operator '*'
        expression.append("*").append(digit);
        helper(s,target,index + 1,expression,
                runningSum - lastOperand + lastOperand * digit,lastOperand * digit,result);
        expression.setLength(len);


        long newOperand;

        if (lastOperand >= 0) {
            newOperand = lastOperand * 10 + digit;
        } else {
            newOperand = lastOperand * 10 - digit;
        }

        expression.append(digit);

        helper(s,target,index + 1,expression,runningSum - lastOperand + newOperand, newOperand,result);

        expression.setLength(len);
    }
}