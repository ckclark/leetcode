package leetcode.evaluate_reverse_polish_notation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
    	Stack<String> stack = new Stack<String>();
    	Set<String> operatorSet = new HashSet<String>(Arrays.asList(new String[]{"+", "-", "*", "/"}));
    	for(String token : tokens){
    		if(operatorSet.contains(token)){
    			int operand2 = Integer.parseInt(stack.pop());
    			int operand1 = Integer.parseInt(stack.pop());
    			if(token.equals("+")){
    				stack.push(Integer.toString(operand1 + operand2));
    			}else if(token.equals("-")){
    				stack.push(Integer.toString(operand1 - operand2));
    			}else if(token.equals("*")){
    				stack.push(Integer.toString(operand1 * operand2));
    			}else if(token.equals("/")){
    				stack.push(Integer.toString(operand1 / operand2));
    			}
    		}else{
    			stack.push(token);
    		}
    	}
    	return Integer.parseInt(stack.pop());
    }
    
    public static void main(String[] args){
    	System.err.println(new Solution().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }
}
