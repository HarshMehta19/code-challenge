class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        start = end = 0
        zeroes = res = 0
        while end < len(nums):
            if nums[end] == 0:
                zeroes+=1
            end +=1

            if zeroes > 1:
                if nums[start] == 0:
                    zeroes -=1
                start+=1

            res = max(end - start - 1,res)
        return res