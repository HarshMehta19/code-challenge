class Solution:
    def numSpecial(self, mat: List[List[int]]) -> int:
        def get_column_sum(col_idx):
            return sum(row[col_idx] for row in mat)

        res = 0
        for row in mat:
            # print("row, idx", row, row.index(1))
            if sum(row) == 1:
                col_idx = row.index(1)
                res += get_column_sum(col_idx) == 1

        return res
