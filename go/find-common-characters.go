package leetcode

func commonChars(A []string) []string {
	merge := make([]int, 26)
	for i, w := range A {
		counter := make([]int, 26)
		for _, c := range w {
			counter[c-'a']++
		}
		for j := 0; j < 26; j++ {
			if i == 0 || merge[j] > counter[j] {
				merge[j] = counter[j]
			}
		}
	}
	ans := []string{}
	for i, v := range merge {
		for j := 0; j < v; j++ {
			ans = append(ans, string('a'+i))
		}
	}
	return ans
}
