class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        cache = {}
        ROWS, COLS = len(matrix), len(matrix[0])
        def helper(row, col):
            if row >= ROWS or col >= COLS:
                return 0

            if (row, col) not in cache:
                down = helper(row+1, col)
                dia = helper(row + 1, col + 1)
                bottom= helper(row, col + 1)

                cache[(row,col)] = 0
                if matrix[row][col] == "1":
                    cache[(row,col)] = 1 + min(down, dia, bottom)

            return cache[(row, col)]

        helper(0,0)
        return max(cache.values()) ** 2
