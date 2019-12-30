package leetcode

import "math"

func largestTriangleArea(points [][]int) float64 {
	l := len(points)
	ans := 0.
	for i := 0; i < l; i++ {
		for j := 0; j < i; j++ {
			for k := 0; k < j; k++ {
				p1, p2, p3 := points[i], points[j], points[k]
				left := p1[0]*p2[1] + p2[0]*p3[1] + p3[0]*p1[1]
				right := p1[1]*p2[0] + p2[1]*p3[0] + p3[1]*p1[0]
				area := math.Abs(float64(left-right) / 2)
				if area > ans {
					ans = area
				}
			}
		}
	}
	return ans
}
