class Solution(object):
    def calcEquation(self, equations, values, queries):
        """
        :type equations: List[List[str]]
        :type values: List[float]
        :type queries: List[List[str]]
        :rtype: List[float]
        """
        var = set()
        distance = dict()
        for (a, b), val in zip(equations, values):
            var.add(a)
            var.add(b)
            distance[a, b] = val
            distance[b, a] = 1 / val
        for v in var:
            distance[v, v] = 1.

        for k in var:
            for i in var:
                for j in var:
                    if (i, j) not in distance:
                        if (i, k) in distance and (k, j) in distance:
                            distance[i, j] = distance[i, k] * distance[k, j]
        return map(lambda q:distance.get(tuple(q), -1.), queries)
