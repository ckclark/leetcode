package leetcode.simplify_path;

import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
    	String[] components = path.split("/");
    	Stack<String> dirStack = new Stack<String>();
    	for(String component : components){
    		if(component.length() == 0) continue;
    		if(component.equals(".")) continue;
    		if(component.equals("..")){
    			if(!dirStack.isEmpty()){
    				dirStack.pop();
    			}
    		}else{
    			dirStack.push(component);
    		}
    	}
    	StringBuilder ans = new StringBuilder("/");
    	String prefix = "";
    	for(String component : dirStack){
    		ans.append(prefix);
    		ans.append(component);
    		prefix = "/";
    	}
    	return ans.toString();
    }
    public static void main(String[] args){
    	System.err.println(new Solution().simplifyPath("/home/ckclark/helloaaa/a/.../../../../././../ckclark/../../../../"));
    }
}
