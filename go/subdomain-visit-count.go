package leetcode

import (
	"fmt"
	"strconv"
	"strings"
)

func subdomainVisits(cpdomains []string) []string {
	counter := make(map[string]int)
	for _, s := range cpdomains {
		sp := strings.Split(s, " ")
		n, err := strconv.Atoi(sp[0])
		if err != nil {
			panic("Impossible")
		}
		url := sp[1]
		idx := 0
		for {
			counter[url[idx:]] += n
			nxtIdx := strings.IndexRune(url[idx:], '.')
			if nxtIdx == -1 {
				break
			}
			idx += nxtIdx + 1
		}
	}
	ans := make([]string, 0, len(counter))
	for k, v := range counter {
		ans = append(ans, fmt.Sprintf("%d %s", v, k))
	}
	return ans
}
