package leetcode

type pos struct {
	x int
	y int
}

func floodFill(image [][]int, sr int, sc int, newColor int) [][]int {
	h, w := len(image), len(image[0])
	size := h * w
	queue := make([]pos, size)
	head, tail := 0, 0
	oldColor := image[sr][sc]
	if oldColor == newColor {
		return image
	}
	queue[head] = pos{x: sr, y: sc}
	image[sr][sc] = newColor
	head++
	for head != tail {
		cur := queue[tail]
		tail = (tail + 1) % size
		var nx, ny int

		nx, ny = cur.x-1, cur.y
		if nx >= 0 && image[nx][ny] == oldColor {
			image[nx][ny] = newColor
			queue[head] = pos{x: nx, y: ny}
			head = (head + 1) % size
		}
		nx, ny = cur.x+1, cur.y
		if nx < h && image[nx][ny] == oldColor {
			image[nx][ny] = newColor
			queue[head] = pos{x: nx, y: ny}
			head = (head + 1) % size
		}
		nx, ny = cur.x, cur.y-1
		if ny >= 0 && image[nx][ny] == oldColor {
			image[nx][ny] = newColor
			queue[head] = pos{x: nx, y: ny}
			head = (head + 1) % size
		}
		nx, ny = cur.x, cur.y+1
		if ny < w && image[nx][ny] == oldColor {
			image[nx][ny] = newColor
			queue[head] = pos{x: nx, y: ny}
			head = (head + 1) % size
		}
	}
	return image
}
