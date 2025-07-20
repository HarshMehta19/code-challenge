class Solution:
    def equalPairs(self, grid: List[List[int]]) -> int:
        rows = defaultdict(int)
        res = 0
        for row in grid:
            rows[tuple(row)] +=1

        for col in range(len(grid)):
            column = tuple(grid[r][col] for r in range(len(grid)))
            if column in rows: res += rows[column]

        return res
