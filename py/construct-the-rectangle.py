class Solution(object):
    def constructRectangle(self, area):
        """
        :type area: int
        :rtype: List[int]
        """
        ans = None
        W = 1
        while W * W <= area:
            if area % W == 0:
                ans = [area / W, W]
            W += 1
        return ans
