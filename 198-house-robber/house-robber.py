class Solution:
    def rob(self, nums: List[int]) -> int:
        dp = [-1] * len(nums)
        def rec(i):
            if i >= len(nums):
                return 0
            
            if i == len(nums) - 1: return nums[i]

            if dp[i] != -1: return dp[i]
            
            dp[i] = max(nums[i] + rec(i+2), rec(i+1))
            return dp[i]

        return max(rec(0), rec(1))