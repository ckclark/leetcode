package leetcode

func rotateString(A string, B string) bool {
	lA, lB := len(A), len(B)
	if lA != lB {
		return false
	}
	if lA == 0 {
		return true
	}
	for i := 0; i < lA; i++ {
		if A[i:] == B[:lA-i] && A[:i] == B[lA-i:] {
			return true
		}
	}
	return false
}
