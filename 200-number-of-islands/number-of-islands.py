class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        res = 0
        rows, cols = len(grid), len(grid[0])
        def dfs(row: int, col: int):
            if row < 0 or row >= rows or col < 0 or col >= cols or grid[row][col] != '1':
                return
            grid[row][col] = '0'
            dfs(row+1, col)
            dfs(row-1, col)
            dfs(row, col + 1)
            dfs(row, col - 1)

        for row in range(rows):
            for col in range(cols):
                if grid[row][col] == '1':
                    res+=1
                    dfs(row, col)
        return res