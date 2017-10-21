class Solution(object):
    def countBattleships(self, board):
        """
        :type board: List[List[str]]
        :rtype: int
        """
        ans = 0
        for r, row in enumerate(board):
            for c, v in enumerate(row):
                if v == 'X':
                    if r > 0 and board[r - 1][c] == 'X':
                        pass
                    elif c > 0 and board[r][c - 1] == 'X':
                        pass
                    else:
                        ans += 1
        return ans
