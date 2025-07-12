class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:

        if not grid:
            return 0

        rowLen, colLen = len(grid), len(grid[0])
        num_islands = 0



        def dfs(row: int, col: int) -> None:

            if row < 0 or row >= rowLen or col < 0 or col >= colLen or grid[row][col] != '1':
                return

            grid[row][col] = 0

            dfs(row+1, col)
            
            dfs(row-1, col)

            dfs(row, col + 1)

            dfs(row, col - 1)
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    num_islands += 1
                    dfs(i, j)

        return num_islands
        
