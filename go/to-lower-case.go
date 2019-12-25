package leetcode

func toLowerCase(str string) string {
	out := []rune(str)
	for i, v := range out {
		if 'A' <= v && v <= 'Z' {
			out[i] = v | 0x20
		}
	}
	return string(out)
}
