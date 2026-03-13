class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        n = len(heights)
        stack = []
        max_area = 0
        for i, height in enumerate(heights):
            start = i
            while stack and stack[-1][0] > height:
                h, j = stack.pop()
                dist = i - j
                a = h * dist
                max_area = max(max_area, a)
                start = j
            stack.append([height, start])

        while stack:
            h, j = stack.pop()
            dist = n - j
            max_area = max(max_area, h * dist)
        
        return max_area
