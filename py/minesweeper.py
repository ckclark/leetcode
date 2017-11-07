class Solution(object):
    def updateBoard(self, board, click):
        """
        :type board: List[List[str]]
        :type click: List[int]
        :rtype: List[List[str]]
        """
        r = len(board)
        if r == 0:
            return board
        c = len(board[0])
        if board[click[0]][click[1]] == 'M':
            board[click[0]][click[1]] = 'X'
            return board
        else:
            cnt = [[0] * len(board[0]) for _ in xrange(len(board))]
            for x, row in enumerate(board):
                for y, v in enumerate(row):
                    if v == 'M':
                        for i in xrange(-1, 2):
                            for j in xrange(-1, 2):
                                if i or j:
                                    if 0 <= x + i < r and 0 <= y + j < c:
                                        cnt[x + i][y + j] += 1
            visited = set()
            q = [tuple(click)]
            for v in q:
                if v not in visited:
                    visited.add(v)
                    if cnt[v[0]][v[1]] > 0:
                        board[v[0]][v[1]] = str(cnt[v[0]][v[1]])
                    else:
                        board[v[0]][v[1]] = 'B'
                        for i in xrange(-1, 2):
                            for j in xrange(-1, 2):
                                if i or j:
                                    nx, ny = v[0] + i, v[1] + j
                                    if 0 <= nx < r and 0 <= ny < c:
                                        q.append((nx, ny))
        return board
