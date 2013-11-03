package leetcode.unique_binary_search_trees;

public class Solution {
    public int numTrees(int n) {
        return Catalan(n);
    }
    public static int Catalan(int n){
    	long ans = 1;
    	for(int i = 1; i <= n; i++){
    		ans *= (2 * n - i + 1);
    		ans /= i;
    	}
    	return (int)(ans / (n + 1));
    }
    
    public static void main(String[] args){
    	for(int i = 0; i < 10; i++){
    		System.err.println(Solution.Catalan(i));
    	}
    }
}
