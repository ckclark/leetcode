package leetcode.different_ways_to_add_parentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        Pattern pat = Pattern.compile("(?<=\\d)[+\\-*]");
        String[] operands_str = pat.split(input);
        Matcher mat = pat.matcher(input);
        List<Integer> operands = new ArrayList<Integer>();
        List<String> operators = new ArrayList<String>();
        while(mat.find()){
            operators.add(mat.group(0));
        }
        for(String operand : operands_str){
            operands.add(Integer.parseInt(operand));
        }
        int l = operands.size();
        List<List<List<Integer>>> table = new ArrayList<List<List<Integer>>>();
        for(int i = 0; i < l; i++){
            List<List<Integer>> subList = new ArrayList<List<Integer>>();
            subList.add(null);
            for(int j = 1; j <= l - i; j++){
                subList.add(new ArrayList<Integer>());
            }
            table.add(subList);
        }
        for(int i = 0; i < l; i++){
            table.get(i).get(1).add(operands.get(i));
        }
        for(int subl = 2; subl <= l; subl++){
            for(int left = 0; left <= l - subl; left++){
                for(int right = left + 1; right < left + subl; right++){
                    List<Integer> llist = table.get(left).get(right - left);
                    List<Integer> rlist = table.get(right).get(subl - (right - left));
                    String op = operators.get(right - 1);
                    List<Integer> list = table.get(left).get(subl);
                    for(int lvalue : llist){
                        for(int rvalue : rlist){
                            if(op.equals("-")){
                                list.add(lvalue - rvalue);
                            }else if(op.equals("+")){
                                list.add(lvalue + rvalue);
                            }else if(op.equals("*")){
                                list.add(lvalue * rvalue);
                            }
                        }
                    }
                }
            }
        }
        return table.get(0).get(l);
    }
}
