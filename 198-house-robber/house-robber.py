class Solution:
    def rob(self, nums: List[int]) -> int:
        #--------------------------Bottom Up ------------------------------------#
        if not nums: return 0

        if len(nums) == 1: return nums[0]

        dp = [0] * len(nums)
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        for i in range(2, len(nums)):
            dp[i] = max(nums[i] + dp[i-2], dp[i-1])

        return dp[-1]

        #--------------------------Top down ------------------------------------#
        # dp = [-1] * len(nums)
        # def rec(i):
        #     if i >= len(nums):
        #         return 0
            
        #     if i == len(nums) - 1: return nums[i]

        #     if dp[i] != -1: return dp[i]
            
        #     dp[i] = max(nums[i] + rec(i+2), rec(i+1))
        #     return dp[i]

        # return max(rec(0), rec(1))