package leetcode

func minCostToMoveChips(chips []int) int {
	odds, evens := 0, 0
	for _, v := range chips {
		if v%2 == 0 {
			evens++
		} else {
			odds++
		}
	}
	if evens > odds {
		return odds
	}
	return evens
}
