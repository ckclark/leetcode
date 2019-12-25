package leetcode

func removeOuterParentheses(S string) string {
	stack, s_stack := make([]rune, 0, len(S)), 0
	for _, c := range S {
		if c == '(' {
			if s_stack > 0 {
				stack = append(stack, c)
			}
			s_stack++
		} else if c == ')' {
			if s_stack > 1 {
				stack = append(stack, c)
			}
			s_stack--
		}
	}
	return string(stack)
}
