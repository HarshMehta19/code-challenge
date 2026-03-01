class Solution:
    def minPartitions(self, n: str) -> int:
        ans = 0
        for num in n:
            ans = max(ans, int(num))

        return ans