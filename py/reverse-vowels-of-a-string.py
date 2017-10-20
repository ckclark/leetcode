class Solution(object):
    def reverseVowels(self, s):
        """
        :type s: str
        :rtype: str
        """
        vowels = list(filter(lambda x:x in 'aeiouAEIOU', s))
        ans = []
        for c in s:
            if c in 'aeiouAEIOU':
                ans.append(vowels.pop())
            else:
                ans.append(c)
        return ''.join(ans)
