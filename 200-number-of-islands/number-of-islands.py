class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        #----------------Iterative----------------
        res = 0
        rows, cols = len(grid), len(grid[0])
        q = deque()
        for row in range(rows):
            for col in range(cols):
                if grid[row][col] == '1':
                    res+=1
                    q.append((row, col))

                    while q:
                        x, y = q.popleft()
                        if x < 0 or x >= rows or y < 0 or y >= cols or grid[x][y] != '1':
                            continue
                        grid[x][y] = '3'
                        q.append((x+1, y))
                        q.append((x-1, y))
                        q.append((x, y+1))
                        q.append((x, y-1))

        return res


        #----------------Recursive----------------
        # res = 0
        # rows, cols = len(grid), len(grid[0])
        # def dfs(row: int, col: int):
        #     if row < 0 or row >= rows or col < 0 or col >= cols or grid[row][col] != '1':
        #         return
        #     grid[row][col] = '0'
        #     dfs(row+1, col)
        #     dfs(row-1, col)
        #     dfs(row, col + 1)
        #     dfs(row, col - 1)

        # for row in range(rows):
        #     for col in range(cols):
        #         if grid[row][col] == '1':
        #             res+=1
        #             dfs(row, col)
        # return res