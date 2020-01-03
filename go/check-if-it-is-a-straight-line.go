package leetcode

func checkStraightLine(coordinates [][]int) bool {
	dx, dy := coordinates[1][0]-coordinates[0][0], coordinates[1][1]-coordinates[0][1]
	lc := len(coordinates)
	for i := 2; i < lc; i++ {
		tx, ty := coordinates[i][0]-coordinates[i-1][0], coordinates[i][1]-coordinates[i-1][1]
		if ty*dx != dy*tx {
			return false
		}
	}
	return true
}
