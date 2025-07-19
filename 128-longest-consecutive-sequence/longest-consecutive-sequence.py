class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0: return 0
        nums.sort()
        last_element, res, count = -inf, 1, 0
        for i in range(0, len(nums)):
            if last_element + 1 == nums[i]:
                count+=1
            elif nums[i] != last_element:
                count = 1

            last_element = nums[i]
            
            res = max(res, count)
        return res