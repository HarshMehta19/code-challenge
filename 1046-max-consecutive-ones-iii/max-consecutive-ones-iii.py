class Solution:
    # Sliding window approach: expand the window with `end`, and shrink from `start` when zeros exceed `k`; ensures the longest window with at most `k` zero flips allowed.

    def longestOnes(self, nums: List[int], k: int) -> int:
        start = end = zeroes = 0

        while end < len(nums):
            if nums[end] == 0:
                zeroes+=1

            end+=1
            if zeroes > k:
                if nums[start] == 0:
                    zeroes-=1
                start+=1
        return end - start
