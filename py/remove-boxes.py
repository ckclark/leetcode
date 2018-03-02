from collections import defaultdict, Counter
from itertools import groupby
class Solution(object):
    def removeBoxes(self, boxes):
        """
        :type boxes: List[int]
        :rtype: int
        """
        table = defaultdict(Counter)
        table_max = Counter()
        B = []
        for k, l in groupby(boxes):
            B.append((k, len(list(l))))
        lB = len(B)
        for i in xrange(lB):
            table[i, i + 1][B[i][1]] = 0
            table_max[i, i + 1] = B[i][1] ** 2
        for l in xrange(2, lB + 1):
            for i in xrange(lB - l + 1):
                fr, to = i, i + l
                table_fr_to = table[fr, to]

                size = B[fr][1]
                table_fr_to[size] = max(table_fr_to[size], table_max[fr + 1, to])
                table_max[fr, to] = max(table_max[fr, to], table_fr_to[size] + size ** 2)

                for sp in xrange(fr + 1, to):
                    if B[fr][0] == B[sp][0]:
                        size_score_l = table[fr, sp]
                        size_score_r = table[sp, to]
                        max_size, max_score = 0, 0
                        size_scores = []
                        for size_l, score_l in size_score_l.iteritems():
                            for size_r, score_r in size_score_r.iteritems():
                                size_scores.append((size_l + size_r, score_l + score_r))
                        size_scores.sort(key=lambda (size, score): (-size, -score))
                        out_size_scores = []
                        for size, score in size_scores:
                            if not out_size_scores:
                                out_size_scores.append((size, score))
                            elif score > out_size_scores[-1][1]:
                                out_size_scores.append((size, score))
                        for size, score in out_size_scores:
                            table_fr_to[size] = max(table_fr_to[size], score)
                            table_max[fr, to] = max(table_max[fr, to], table_fr_to[size] + size ** 2)
        return table_max[0, lB]
