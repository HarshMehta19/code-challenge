class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i, size = 0, len(nums)
        while i < size:
            if nums[i] == 0:
                j = i+1
                while j<size and nums[j]==0:
                    j+=1
                if j<size: 
                    nums[i] = nums[j]
                    nums[j] = 0
            i+=1