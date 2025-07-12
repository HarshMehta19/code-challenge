class Solution:
    def canMeasureWater(self, x: int, y: int, target: int) -> bool:
        seen = set()
        if x + y < target: return False
        
        def dfs(tot):
            if tot == target:
                return True
            if tot in seen or tot < 0 or tot > x + y:
                return False

            seen.add(tot)

            return dfs(tot + x) or dfs(tot - x) or dfs(tot + y) or dfs(tot - y)

        return dfs(0)