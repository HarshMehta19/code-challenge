class NumMatrix:

    def __init__(self, matrix: List[List[int]]):
        ROWS, COLS = len(matrix), len(matrix[0])
        self.sumMat = [[0] * (COLS + 1) for _ in range(ROWS+1)]

        for row in range(ROWS):
            prefix = 0
            for col in range(COLS):
                prefix += matrix[row][col]
                above = self.sumMat[row][col+1]
                self.sumMat[row+1][col+1] = prefix + above

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        bottomRight = self.sumMat[row2+1][col2+1]
        above = self.sumMat[row1][col2+1]
        left = self.sumMat[row2 + 1][col1]
        topLeft = self.sumMat[row1][col1]

        return bottomRight - above - left + topLeft

# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# param_1 = obj.sumRegion(row1,col1,row2,col2)