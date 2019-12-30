package leetcode

import "strings"

func toGoatLatin(S string) string {
	ans := make([]string, 0, len(S))
	for i, w := range strings.Split(S, " ") {
		b := strings.Builder{}
		if strings.Index("aeiouAEIOU", string(w[0])) == -1 {
			b.WriteString(w[1:])
			b.WriteRune(rune(w[0]))
		} else {
			b.WriteString(w)
		}
		b.WriteString("ma")
		for j := 0; j <= i; j++ {
			b.WriteRune('a')
		}
		ans = append(ans, b.String())
	}
	return strings.Join(ans, " ")
}
