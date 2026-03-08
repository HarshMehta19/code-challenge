class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prefix, postfix = 1, 1
        n = len(nums)
        ans = [1] * len(nums)

        for i in range(len(nums)):
            ans[i] *= prefix
            prefix *= nums[i]

        for i in range(len(nums) - 1, -1, -1):
            ans[i] *= postfix
            postfix *= nums[i]

        return ans
