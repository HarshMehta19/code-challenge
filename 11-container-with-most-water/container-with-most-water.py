class Solution:
    def maxArea(self, height: List[int]) -> int:
        start, end = 0, len(height) - 1
        maxWater = 0

        while(start<end):
            minHeight = min(height[start], height[end])
            distance = end - start
            maxWater = max(maxWater, distance * minHeight)
            while start < end and height[start]<=minHeight: start+=1
            while start < end and height[end] <= minHeight: end-=1
        
        return maxWater