class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        larr = len(arr)
        L, U = -1, larr
        while L + 1 < U:
            mid = L + (U - L) / 2
            if arr[mid] > x:
                U = mid
            else:
                L = mid
        Lary, Uary = [], []
        while len(Lary) + len(Uary) < k:
            Lcand, Ucand = None, None
            if L >= 0:
                Lcand = arr[L]
            if U < larr:
                Ucand = arr[U]
            if Lcand is None:
                Uary.append(Ucand)
                U += 1
            elif Ucand is None:
                Lary.append(Lcand)
                L -= 1
            else:
                if abs(Lcand - x) <= abs(Ucand - x):
                    Lary.append(Lcand)
                    L -= 1
                else:
                    Uary.append(Ucand)
                    U += 1
        return Lary[::-1] + Uary
