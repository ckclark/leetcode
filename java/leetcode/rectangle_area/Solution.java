package leetcode.rectangle_area;

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
        int l = Math.max(A, E);
        int r = Math.min(G, C);
        int u = Math.min(D, H);
        int d = Math.max(B, F);
        if(r > l && u > d){
            return area1 - (u - d) * (r - l) + area2;
        }else{
            return area1 + area2;
        }
    }
}
