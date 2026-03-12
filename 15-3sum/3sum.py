class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        nums.sort()
        length = len(nums)
        res = []
        for i in range(length):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            left = i+1
            right = length - 1
            while left < right:
                current_sum = nums[i] + nums[left] + nums[right]
                if current_sum == 0:
                    res.append([nums[i], nums[left], nums[right]])
                    left+=1
                    right-=1
                    while nums[left] == nums[left-1] and left < right:
                        left+=1
                elif current_sum < 0:
                    left+=1
                else:
                    right-=1
        
        return res



