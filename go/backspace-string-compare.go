package leetcode

func backspaceCompare(S string, T string) bool {
	lS, lT := len(S), len(T)

	iS, iT := lS-1, lT-1
	bS, bT := 0, 0
	for iS >= 0 || iT >= 0 {
		for iS >= 0 && (bS > 0 || S[iS] == byte('#')) {
			if S[iS] == byte('#') {
				bS++
			} else {
				bS--
			}
			iS--
		}
		for iT >= 0 && (bT > 0 || T[iT] == byte('#')) {
			if T[iT] == byte('#') {
				bT++
			} else {
				bT--
			}
			iT--
		}
		if iS >= 0 && iT >= 0 {
			if S[iS] != T[iT] {
				return false
			} else {
				iS--
				iT--
			}
		} else if iT >= 0 || iS >= 0 {
			return false
		}
	}
	return true
}
