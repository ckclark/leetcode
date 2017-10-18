class Solution(object):
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        head, tail = 0, len(numbers) - 1
        while head < tail:
            s = numbers[head] + numbers[tail]
            if s == target:
                return [head + 1, tail + 1]
            elif s < target:
                head += 1
            elif s > target:
                tail -= 1

