class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:

        neis = [[0,1],[1,0],[-1,0],[0,-1]]
        rows = len(image)
        cols = len(image[0])

        def dfs(row, col, starting_pixel):
            q = [[row, col]]
            while q:
                # print("q", q)
                dx, dy = q.pop(0)
                for nei in neis:
                    x = dx+nei[0]
                    y = dy+nei[1]
                    if x<rows and x>=0 and y<cols and y>=0 and image[x][y]==starting_pixel:
                        image[x][y]=color
                        q.append([x,y])
        if image[sr][sc]==color:
            return image
        else:
            oldColor = image[sr][sc]
            image[sr][sc]=color
            dfs(sr,sc,oldColor)
            return image