package leetcode.restore_ip_addresses;

import java.util.ArrayList;

public class Solution {
	public static final int IP_BYTES = 4;
	public void dfs(ArrayList<String> ans, char[] input, int offset, int length, int[] ipaddr, int depth){
		if(offset == length && depth == IP_BYTES){
			ans.add(ipaddr[0] + "." + ipaddr[1] + "." + ipaddr[2] + "." + ipaddr[3]);
		}else if(offset < length && depth < IP_BYTES){
			ipaddr[depth] = input[offset] - '0';
			dfs(ans, input, offset + 1, length, ipaddr, depth + 1);
			if(offset + 2 <= length){
				int d = (input[offset] - '0') * 10 + (input[offset + 1] - '0');
				if(d >= 10){
					ipaddr[depth] = d;
					dfs(ans, input, offset + 2, length, ipaddr, depth + 1);
				}
			}
			if(offset + 3 <= length){
				int d = (input[offset] - '0') * 100 + (input[offset + 1] - '0') * 10 + (input[offset + 2] - '0');
				if(d >= 100 && d < 256){
					ipaddr[depth] = d;
					dfs(ans, input, offset + 3, length, ipaddr, depth + 1);
				}
			}
		}
	}

	public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> ans = new ArrayList<String>();
        dfs(ans, s.toCharArray(), 0, s.length(), new int[4], 0);
        return ans;
    }
	
	public static void main(String[] args){
		ArrayList<String> ans = new Solution().restoreIpAddresses("999101");
		for(String s : ans){
			System.err.println(s);
		}
	}
}
