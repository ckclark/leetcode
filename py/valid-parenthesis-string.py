from collections import Counter
class Solution(object):
    def dfs(self, s, pos, stack):
        if stack + self.min_possible_opening[-1] - self.min_possible_opening[pos] > self.max_possible_closing[-1] - self.max_possible_closing[pos]:
            return False
        if stack + self.max_possible_opening[-1] - self.max_possible_opening[pos] < self.min_possible_closing[-1] - self.min_possible_closing[pos]:
            return False
        if pos == len(s):
            return not stack
        if s[pos] == '(':
            stack += 1
            if self.dfs(s, pos + 1, stack):
                return True
            stack -= 1
        elif s[pos] == ')':
            if not stack:
                return False
            else:
                stack -= 1
                if self.dfs(s, pos + 1, stack):
                    return True
                stack += 1
        else:
            if stack: # treat as ')'
                stack -= 1
                if self.dfs(s, pos + 1, stack):
                    return True
                stack += 1
            # treat as '('
            stack += 1
            if self.dfs(s, pos + 1, stack):
                return True
            stack -= 1

            # treat as ''
            if self.dfs(s, pos + 1, stack):
                return True
        return False

    def checkValidString(self, s):
        """
        :type s: str
        :rtype: bool
        """
        c = Counter(s)
        mpo, mpc = c['('] + c['*'], c[')'] + c['*']

        self.max_possible_opening = [0]
        self.min_possible_opening = [0]
        self.max_possible_closing = [0]
        self.min_possible_closing = [0]
        for c in s:
            self.min_possible_opening.append(self.min_possible_opening[-1] + (c == '('))
            self.max_possible_opening.append(self.max_possible_opening[-1] + (c != ')'))
            self.min_possible_closing.append(self.min_possible_closing[-1] + (c == ')'))
            self.max_possible_closing.append(self.max_possible_closing[-1] + (c != '('))

        return self.dfs(s, 0, 0)
