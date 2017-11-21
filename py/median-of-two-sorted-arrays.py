class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1
        l1, l2 = len(nums1), len(nums2)

        m = min(nums1[:1] + nums2[:1])
        M = max(nums1[-1:] + nums2[-1:])


        # 0123456789
        # .4.5.6.
        # .1.2.3.
        L, U = 0, l1 * 2 + 1
        while L + 1 < U:
            mid1 = (L + U) / 2
            mid2 = l1 + l2 - mid1
            L1 = m if mid1 == 0 else nums1[(mid1 - 1) / 2]
            R1 = M if mid1 == 2 * l1 else nums1[mid1 / 2]
            L2 = m if mid2 == 0 else nums2[(mid2 - 1) / 2]
            R2 = M if mid2 == 2 * l2 else nums2[mid2 / 2]
            if L1 > R2:
                U = mid1
            else:
                L = mid1
        C1, C2 = L, l1 + l2 - L
        L1 = m if C1 == 0 else nums1[(C1 - 1) / 2]
        R1 = M if C1 == 2 * l1 else nums1[C1 / 2]
        L2 = m if C2 == 0 else nums2[(C2 - 1) / 2]
        R2 = M if C2 == 2 * l2 else nums2[C2 / 2]
        return (max(L1, L2) + min(R1, R2)) / 2.
