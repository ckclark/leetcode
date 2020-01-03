package leetcode

func isLongPressedName(name string, typed string) bool {
	in, it := 0, 0
	ln, lt := len(name), len(typed)
	for in < ln || it < lt {
		if in < ln && it < lt {
			if name[in] == typed[it] {
				in++
				it++
			} else if in == 0 {
				return false
			} else if name[in-1] == typed[it] {
				it++
			} else {
				return false
			}
		} else if it == lt {
			return false
		} else if name[in-1] == typed[it] {
			it++
		}
	}
	return true
}
