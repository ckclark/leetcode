class Solution(object):
    def calPoints(self, ops):
        """
        :type ops: List[str]
        :rtype: int
        """
        s = 0
        stack = []
        for c in ops:
            try:
                v = int(c)
                stack.append(v)
            except ValueError:
                if c == 'C':
                    stack.pop()
                elif c == 'D':
                    stack.append(stack[-1] * 2)
                elif c == '+':
                    stack.append(stack[-1] + stack[-2])
        return sum(stack)


