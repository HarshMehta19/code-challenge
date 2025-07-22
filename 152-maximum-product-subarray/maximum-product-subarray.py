class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0: return 0
        prefix = suffix = 1
        res = nums[0]
        n = len(nums)
        for i in range(n):
            prefix = nums[i] * (prefix or 1)
            suffix = nums[n-i-1] * (suffix or 1)
            res = max(res, prefix, suffix)

        return res