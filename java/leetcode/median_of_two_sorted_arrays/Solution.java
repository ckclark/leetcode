package leetcode.median_of_two_sorted_arrays;

import java.util.ArrayList;
import java.util.Random;

public class Solution {
	public int findLess(int[] ary, int v){
		int U = ary.length;
		int L = -1;
		while(L + 1 < U){
			int mid = L + (U - L) / 2;
			if(ary[mid] < v){
				L = mid;
			}else{
				U = mid;
			}
		}
		return L + 1;
	}
	
	public int findMore(int[] ary, int v){
		int U = ary.length;
		int L = -1;
		while(L + 1 < U){
			int mid = L + (U - L) / 2;
			if(ary[mid] > v){
				U = mid;
			}else{
				L = mid;
			}
		}
		return ary.length - L - 1;
	}
	
    public double findMedianSortedArrays(int A[], int B[]) {
    	if(A.length == 0){
    		return ((double)B[B.length / 2] + B[(B.length - 1) / 2]) / 2;
    	}else if(B.length == 0){
    		return ((double)A[A.length / 2] + A[(A.length - 1) / 2]) / 2;
    	}else if(A[0] >= B[B.length - 1]){
    		int idx1 = (A.length + B.length) / 2;
    		int idx2 = (A.length + B.length - 1) / 2;
    		int v1, v2;
    		if(idx1 >= B.length){
    			v1 = A[idx1 - B.length];
    		}else{
    			v1 = B[idx1];
    		}
    		if(idx2 >= B.length){
    			v2 = A[idx2 - B.length];
    		}else{
    			v2 = B[idx2];
    		}
    		return ((double)v1 + v2) / 2;
    	}else if(B[0] >= A[A.length - 1]){
    		int idx1 = (A.length + B.length) / 2;
    		int idx2 = (A.length + B.length - 1) / 2;
    		int v1, v2;
    		if(idx1 >= A.length){
    			v1 = B[idx1 - A.length];
    		}else{
    			v1 = A[idx1];
    		}
    		if(idx2 >= A.length){
    			v2 = B[idx2 - A.length];
    		}else{
    			v2 = A[idx2];
    		}
    		return ((double)v1 + v2) / 2;
    	}
    	int lenA = A.length;
    	int lenB = B.length;
    	int U = lenA;
    	int L = -1;
    	int mid = -1;
    	int lessA = 0, lessB = 0, moreA = 0, moreB = 0, equalA = 0, equalB = 0;
    	int upperEqual = 0;
    	int lowerEqual = 0;
    	while(mid != L + (U - L) / 2){
    		mid = L + (U - L) / 2;
    		if(mid == -1) break;
    		int value = A[mid];
    		lessA = findLess(A, value);
    		lessB = findLess(B, value);
    		moreA = findMore(A, value);
    		moreB = findMore(B, value);
    		equalA = lenA - lessA - moreA;
    		equalB = lenB - lessB - moreB;
    		upperEqual = (moreA + moreB) + (equalA + equalB);
    		lowerEqual = (lessA + lessB) + (equalA + equalB);
    		if(upperEqual * 2 >= lenA + lenB && lowerEqual * 2 < lenA + lenB){
    			L = mid;
    		}else if(upperEqual * 2 < lenA + lenB && lowerEqual * 2 >= lenA + lenB){
    			U = mid;
    		}else{
    			break;
    		}
    	}
    	if(mid == -1){
    		int idx1 = (A.length + B.length) / 2;
			int idx2 = (A.length + B.length - 1) / 2;
    		return ((double)B[idx1] + B[idx2]) / 2;
    	}
    	if((moreA + moreB) * 2 < lenA + lenB && (lessA + lessB) * 2 < lenA + lenB){
    		return A[mid];
    	}else if((moreA + moreB) * 2 >= lenA + lenB && (lessA + lessB) * 2 < lenA + lenB){
    		if(lowerEqual * 2 >= lenA + lenB){
    			int moreABit = 0;
    			boolean inited = false;
    			if(lessA + equalA < lenA){
    				moreABit = A[lessA + equalA];
    				inited = true;
    			}
    			if(lessB + equalB < lenB){
    				if(!inited || B[lessB + equalB] < moreABit){
    					moreABit = B[lessB + equalB];
    				}
    			}
    			return ((double)A[mid] + moreABit) / 2;
    		}else{
    			int idx1 = (A.length + B.length) / 2;
    			int idx2 = (A.length + B.length - 1) / 2;
    			return ((double)B[idx1 - lessA - equalA] + B[idx2 - lessA - equalA]) / 2;
    		}
    	}else if((moreA + moreB) * 2 < lenA + lenB && (lessA + lessB) * 2 >= lenA + lenB){
    		if(upperEqual * 2 >= lenA + lenB){
    			int lessABit = 0;
    			boolean inited = false;
    			if(lessA > 0){
    				lessABit = A[lessA - 1];
    				inited = true;
    			}
    			if(lessB > 0){
    				if(!inited || B[lessB - 1] > lessABit){
    					lessABit = B[lessB - 1];
    				}
    			}
    			return ((double)A[mid] + lessABit) / 2;
    		}else{
    			int idx1 = (A.length + B.length) / 2;
    			int idx2 = (A.length + B.length - 1) / 2;
    			return ((double)B[idx1 - lessA - equalA] + B[idx2 - lessA - equalA]) / 2;
    		}
    	}else{ //impossible
    		return 0;
    	}
    }
    
    public static void main(String[] args){
    	final int cases = 1000;
    	final int N = 10;
    	for(int _ = 0; _ < cases; _++){
    		ArrayList<Integer> input = new ArrayList<Integer>();
    		Random r = new Random();
    		int prev = 0;
    		for(int i = 0; i < N; i++){
    			int next = prev + r.nextInt(2);
    			input.add(next);
    			prev = next;
    		}
    		ArrayList<Integer> list1 = new ArrayList<Integer>();
    		ArrayList<Integer> list2 = new ArrayList<Integer>();
    		for(int i = 0; i < N; i++){
    			if(r.nextInt(2) > 0){
    				list1.add(input.get(i));
    			}else{
    				list2.add(input.get(i));
    			}
    		}
    		int[] input1 = new int[list1.size()];
    		int[] input2 = new int[list2.size()];
    		for(int i = 0; i < list1.size(); i++){
    			input1[i] = list1.get(i);
    		}
    		for(int i = 0; i < list2.size(); i++){
    			input2[i] = list2.get(i);
    		}
    		try{
    			double ans = new Solution().findMedianSortedArrays(input1, input2);
    			double ans2 = ((double)input.get(N / 2) + input.get((N - 1) / 2)) / 2;
    			if(ans != ans2){
    				for(int x : input1){
    					System.err.print(x + " ");
    				}
    				System.err.println("");
    				for(int x : input2){
    					System.err.print(x + " ");
    				}
    				System.err.println("");
    			}
    		}catch(Exception ex){
        		for(int x : input1){
        			System.err.print(x + " ");
        		}
        		System.err.println("");
        		for(int x : input2){
        			System.err.print(x + " ");
        		}
        		System.err.println("");
    			
    		}
    	}
//    	System.err.println(new Solution().findMedianSortedArrays(new int[]{2}, new int[]{0,0,0,0,0,0,2,2,3,3}));
    }
}
