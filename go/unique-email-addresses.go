package leetcode

import "strings"

func numUniqueEmails(emails []string) int {
	set := make(map[string]struct{})
	for _, email := range emails {
		plus := strings.Index(email, "+")
		at := strings.Index(email, "@")
		if plus == -1 {
			plus = at
		}
		x := strings.Replace(email[:plus], ".", "", -1) + email[at:]
		set[x] = struct{}{}
	}
	return len(set)
}
