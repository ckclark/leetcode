package leetcode.scramble_string;

public class Solution {
	public static class MyLetterHash{
		public static final int[] PRIMES = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,};
		public static final int SIZE = 26;
		public static final int MODULUS = 21262211;
		int hash, len;
		
		public MyLetterHash(String s){
			char[] chars = s.toCharArray();
			int tmp = 1;
			len = chars.length;
			for(int i = 0; i < len; i++){
				tmp *= PRIMES[chars[i] - 'a'];
				tmp %= MODULUS;
			}
			hash = tmp;
		}
		
		@Override
		public int hashCode() {
			return hash;
		}

		@Override
		public boolean equals(Object obj) {
			MyLetterHash cmp = (MyLetterHash)obj;
			return cmp.hash == this.hash && cmp.len == this.len;
		}
		
	}
	
	public boolean isScramble(String s1, String s2) {
    	int len = s1.length();
    	if(s1.equals(s2)) return true;
    	else{
    		for(int i = 1; i < len; i++){
    			String left1 = s1.substring(0, i);
    			String right1 = s1.substring(i);
    			MyLetterHash leftHash1 = new MyLetterHash(left1);
    			MyLetterHash rightHash1 = new MyLetterHash(right1);
    			String left2, right2;
    			MyLetterHash leftHash2, rightHash2;
    			
    			left2 = s2.substring(0, i);
    			right2 = s2.substring(i);
    			leftHash2 = new MyLetterHash(left2);
    			rightHash2 = new MyLetterHash(right2);
    			if(leftHash1.equals(leftHash2) && rightHash1.equals(rightHash2)){
    				if(isScramble(left1, left2) && isScramble(right1, right2)) return true;
    			}

    			left2 = s2.substring(len - i);
    			right2 = s2.substring(0, len - i);
    			leftHash2 = new MyLetterHash(left2);
    			rightHash2 = new MyLetterHash(right2);
    			if(leftHash1.equals(leftHash2) && rightHash1.equals(rightHash2)){
    				if(isScramble(left1, left2) && isScramble(right1, right2)) return true;
    			}
    		}
    	}
    	return false;
    }
	
	public static void main(String[] args){
		System.err.println(new Solution().isScramble("rgtae", "great"));
	}
}
