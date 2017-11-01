class Solution(object):
    def compress(self, chars):
        """
        :type chars: List[str]
        :rtype: int
        """
        idx = 0
        prev = None
        cnt = 0
        for c in chars:
            if c == prev:
                cnt += 1
            else:
                if prev is not None:
                    chars[idx] = prev
                    idx += 1
                    if cnt > 1:
                        for cnt_c in str(cnt):
                            chars[idx] = cnt_c
                            idx += 1
                cnt = 1
                prev = c

        if prev is not None:
            chars[idx] = prev
            idx += 1
            if cnt > 1:
                for cnt_c in str(cnt):
                    chars[idx] = cnt_c
                    idx += 1
        return idx
