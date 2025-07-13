class Solution:
    def numSquares(self, n: int) -> int:
        dp = [float('inf')] * (n + 1)
        dp[0] = 0
        
        for target in range(1, int(sqrt(n))+1):
            target = target**2
            for j in range(target, n+1):
                
                dp[j] = min(dp[j], 1 + dp[j-target])
                
        return dp[n]