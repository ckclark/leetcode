package leetcode

import "math"

func distributeCandies(candies int, num_people int) []int {
	rounds := int((math.Sqrt(8.*float64(candies)+1.5) - 1) / 2)
	ans := make([]int, num_people)
	for i := 1; i <= num_people; i++ {
		cnt := rounds / num_people
		ans[i-1] += cnt * (2*i + (cnt-1)*num_people) / 2
		if rounds%num_people >= i {
			ans[i-1] += i + cnt*num_people
		}
	}
	used := rounds * (rounds + 1) / 2
	if used < candies {
		ans[rounds%num_people] += candies - used
	}
	return ans
}
