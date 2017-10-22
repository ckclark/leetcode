from collections import Counter
class Solution(object):
    def originalDigits(self, s):
        """
        :type s: str
        :rtype: str
        """
        phase1 = dict(
                g=(8, 'eight'),
                u=(4, 'four'),
                w=(2, 'two'),
                x=(6, 'six'),
                z=(0, 'zero')
            )
        phase2 = dict(
                t=(3, 'thre'),
                s=(7, 'sevn'),
                o=(1, 'one'),
                f=(5, 'five')
            )
        phase3 = dict(
                i=(9, 'nie')
            )

        counter = Counter(s)
        ansCounter = Counter()
        for k, (n, w) in phase1.iteritems():
            ck = counter[k]
            ansCounter[n] += ck
            for c in w:
                counter[c] -= ck

        for k, (n, w) in phase2.iteritems():
            ck = counter[k]
            ansCounter[n] += ck
            for c in w:
                counter[c] -= ck

        for k, (n, w) in phase3.iteritems():
            ck = counter[k]
            ansCounter[n] += ck
            for c in w:
                counter[c] -= ck

        return ''.join(str(i) * ansCounter[i] for i in xrange(10))

