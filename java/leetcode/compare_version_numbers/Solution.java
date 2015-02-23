package leetcode.compare_version_numbers;

public class Solution {
    public int compareVersion(String version1, String version2) {
    	version1 = version1.replaceAll("(\\.0+)+$", "");
    	version2 = version2.replaceAll("(\\.0+)+$", "");
        String[] sp1 = version1.split("\\.");
        String[] sp2 = version2.split("\\.");
        int l1 = sp1.length;
        int l2 = sp2.length;
        int l = Math.min(l1, l2);
        for(int i = 0; i < l; i++){
        	String n1 = sp1[i].replaceAll("^0+", "");
        	String n2 = sp2[i].replaceAll("^0+", "");
        	if(n1.length() > n2.length()){
        		return 1;
        	}else if(n1.length() < n2.length()){
        		return -1;
        	}else{
        		int cmp = n1.compareTo(n2);
        		if(cmp > 0) return 1;
        		if(cmp < 0) return -1;
        	}
        }
        if(l1 > l2) return 1;
        if(l1 < l2) return -1;
        return 0;
    }
}