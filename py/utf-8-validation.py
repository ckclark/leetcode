class Solution(object):
    def validUtf8(self, data):
        """
        :type data: List[int]
        :rtype: bool
        """
        it = iter(data)
        while True:
            try:
                c = it.next() & 0xff
                try:
                    t = 0x80
                    n = 0
                    while t > 0:
                        if t & c:
                            n += 1
                            t >>= 1
                        else:
                            break
                    if n == 1 or n > 4:
                        return False
                    elif n > 1:
                        for _ in xrange(n - 1):
                            c = it.next() & 0xff
                            if c & 0xc0 != 0x80:
                                return False
                except StopIteration:
                    return False
            except StopIteration:
                return True

