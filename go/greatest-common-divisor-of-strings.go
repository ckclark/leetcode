package leetcode

func gcdOfStrings(str1 string, str2 string) string {
	l1, l2 := len(str1), len(str2)
	if l1 < l2 {
		if str1[:l1] != str2[:l1] {
			return ""
		}
		return gcdOfStrings(str1, str2[l1:])
	} else if l1 > l2 {
		if str1[:l2] != str2[:l2] {
			return ""
		}
		return gcdOfStrings(str1[l2:], str2)
	}

	if str1 == str2 {
		return str1
	} else {
		return ""
	}
}
