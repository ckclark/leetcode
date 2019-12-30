package leetcode

func duplicateZeros(arr []int) {
	zeroCnt := 0
	l := len(arr)
	last_dup := false
	for idx, v := range arr {
		if v == 0 {
			if idx+zeroCnt+1 < l {
				if idx+zeroCnt+2 == l {
					last_dup = true
				}
				zeroCnt++
			}
		}
		if idx+zeroCnt >= l {
			break
		}
	}
	t := l - 1
	for i := 0; i < l-zeroCnt; i++ {
		if (i > 0 || last_dup) && arr[l-zeroCnt-1-i] == 0 {
			arr[t] = arr[l-zeroCnt-1-i]
			t--
		}
		arr[t] = arr[l-zeroCnt-1-i]
		t--
	}
}
