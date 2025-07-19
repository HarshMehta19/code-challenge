class Solution:
    # Two-pointer approach: start from both ends and calculate area using the shorter height; move the pointer at the shorter line inward to explore potentially larger areas, skipping heights ≤ current min since they can't improve the result.
    def maxArea(self, height: List[int]) -> int:
        start, end = 0, len(height) - 1
        maxLeft, maxRight = height[start], height[end]
        result = 0
        while(start < end):
            distance = end - start
            minHeight = min(height[start], height[end])
            result = max(result, distance * minHeight)
            while(start < end and height[start]<=minHeight): start+=1            
            while(start < end and height[end]<= minHeight): end-=1

        return result