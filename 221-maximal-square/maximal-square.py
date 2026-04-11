class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:

        # ---------------- Bottom - up -----------------------
        ROWS, COLS = len(matrix), len(matrix[0])
        dp = [[0] * (COLS + 1) for _ in range(ROWS + 1)]
        max_square = 0

        for row in range(ROWS - 1, -1, -1):
            for col in range(COLS - 1, -1, -1):
                if matrix[row][col] == "1":
                    down = dp[row + 1][col]
                    dia = dp[row + 1][col + 1]
                    bottom = dp[row][col + 1]

                    dp[row][col] = 1 + min(down, dia, bottom)
                    max_square = max(max_square, dp[row][col])

        return max_square**2
        # ------------------- Top-down------------------------
        # cache = {}
        # ROWS, COLS = len(matrix), len(matrix[0])
        # def helper(row, col):
        #     if row >= ROWS or col >= COLS:
        #         return 0

        #     if (row, col) not in cache:
        #         down = helper(row+1, col)
        #         dia = helper(row + 1, col + 1)
        #         bottom= helper(row, col + 1)

        #         cache[(row,col)] = 0
        #         if matrix[row][col] == "1":
        #             cache[(row,col)] = 1 + min(down, dia, bottom)

        #     return cache[(row, col)]

        # helper(0,0)
        # return max(cache.values()) ** 2
