package leetcode.max_points_on_a_line;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import common.Point;

public class Solution {
	public static class Slope{
		int num, den;
		boolean negative = false;
		public Slope(int num, int den){
			if(num < 0){
				negative = !negative;
				num = -num;
			}
			if(den < 0){
				negative = !negative;
				den = -den;
			}
			if(den == 0){
				if(num > 0){
					num = 1;
				}
			}else if(num == 0){
				if(den > 0){
					den = 1;
				}
			}else{
				int a = num, b = den;
				while(a % b != 0){
					int tmp = b;
					b = a % b;
					a = tmp;
				}
				num /= b;
				den /= b;
			}
			
			this.num = num;
			this.den = den;
		}
		@Override
		public int hashCode() {
			return num ^ den;
		}
		
		@Override
		public boolean equals(Object obj) {
			Slope m = (Slope)obj;
			return m.negative == this.negative && m.den == this.den && m.num == this.num;
		}
	}
	public static class Union{
		int parent, size;
		public Union(int parent, int size){
			this.parent = parent;
			this.size = size;
		}
	}
	
	public static int find_root(Map<Integer, Union> map, int idx){
		Union u = map.get(idx);
		if(u.parent != idx){
			u.parent = find_root(map, u.parent);
		}
		return u.parent;
	}
	
	public static void link_root(Map<Integer, Union> map, int a, int b){
		int p_a = find_root(map, a);
		int p_b = find_root(map, b);
		if(p_a != p_b){
			Union ur_a = map.get(p_a);
			Union ur_b = map.get(p_b);
			if(ur_a.size < ur_b.size){
				ur_a.parent = p_b;
				ur_b.size += ur_a.size;
			}else{
				ur_b.parent = p_a;
				ur_a.size += ur_b.size;
			}
		}
	}
	
    public int maxPoints(Point[] points) {
    	int n = points.length;
    	if(n == 0) return 0;
    	int max = 1;
    	ArrayList<Point> pArray = new ArrayList<Point>();
    	int[] duplicates = new int[n];
    	for(int i = 0; i < n; i++){
    		boolean found = false;
    		for(int j = 0; j < pArray.size(); j++){
    			Point p = pArray.get(j);
    			if(p.x == points[i].x && p.y == points[i].y){
    				found = true;
    				duplicates[j]++;
    				if(duplicates[j] > max){
    					max = duplicates[j];
    				}
    				break;
    			}
    		}
    		if(!found){
    			duplicates[pArray.size()] = 1;
    			pArray.add(points[i]);
    		}
    	}
    	Map<Slope, Map<Integer, Union>> map = new HashMap<Slope, Map<Integer, Union>>();
    	n = pArray.size();
    	for(int i = 0; i < n; i++){
    		for(int j = i + 1; j < n; j++){
    			Point p_i = pArray.get(i);
    			Point p_j = pArray.get(j);
    			Slope m = new Slope(p_i.y - p_j.y, p_i.x - p_j.x);
    			Map<Integer, Union> unionMap = map.get(m);
    			if(unionMap == null){
    				unionMap = new HashMap<Integer, Union>();
    				map.put(m, unionMap);
    			}
    			Union u_i = unionMap.get(i);
    			Union u_j = unionMap.get(j);
    			if(u_i == null){
    				u_i = new Union(i, duplicates[i]);
    				unionMap.put(i, u_i);
    			}
    			if(u_j == null){
    				u_j = new Union(j, duplicates[j]);
    				unionMap.put(j, u_j);
    			}
    			link_root(unionMap, i, j);
    		}
    	}
    	for(Map<Integer, Union> m : map.values()){
    		for(Union u : m.values()){
    			if(u.size > max)
    				max = u.size;
    		}
    	}
    	return max;
    }
    
    public static void main(String[] args){
    	final int N = 0;
    	Point[] input = new Point[N];
    	Random r = new Random();
    	for(int i = 0; i < N; i++){
    		input[i] = new Point(r.nextInt(2), r.nextInt(2));
    		System.err.println("new Point(" + input[i].x + ", " + input[i].y + "),");
    	}
    	System.err.println(new Solution().maxPoints(input));
    }
}
