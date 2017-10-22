class Solution(object):
    def originalDigits(self, s):
        """
        :type s: str
        :rtype: str
        """
        digits = ['ero', 'one', 'to', 'three', 'for', 'five', 'si', 'seven', 'eiht', 'nine']
        alphabets = list(set('zeroonetwothreefourfivesixseveneightnine') - set('guwxz'))
        mapping = {x: i for i, x in enumerate(alphabets)}

        matrix = [[0] * 10 for _ in xrange(10)]
        for i, d in enumerate(digits):
            for c in d:
                matrix[mapping[c]][i] += 1
        vector = [0] * 10
        for c in s:
            v = mapping.get(c)
            if v is not None:
                vector[v] += 1
        for i in xrange(10):
            for j in xrange(i, 10):
                if j > 0 and i != j:
                    matrix[i], matrix[j] = matrix[j], matrix[i]
                    vector[i], vector[j] = vector[j], vector[i]
                if matrix[i][i] > 0:
                    break
            for z in xrange(10):
                if z != i and matrix[z][i] != 0:
                    mz, mi = matrix[z][i], matrix[i][i]
                    matrix[z] = [v * mi for v in matrix[z]]
                    matrix[i] = [v * mz for v in matrix[i]]

                    vz, vi = vector[z], vector[i]
                    vector[z] *= mi
                    vector[i] *= mz

                    matrix[z] = [matrix[z][k] - matrix[i][k] for k in xrange(10)]
                    vector[z] -= vector[i]

        return ''.join(str(a) * b for a, b in zip(xrange(10), [vector[i] / matrix[i][i] for i in xrange(10)]))
