class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        maxSum = currSum = sum(nums[:k])
        l, r = 1, k
        while l <= r and r < len(nums):
            currSum -= nums[l-1]
            currSum+= nums[r]
            maxSum = max(maxSum, currSum) 
            l+=1
            r+=1
        
        return maxSum / k