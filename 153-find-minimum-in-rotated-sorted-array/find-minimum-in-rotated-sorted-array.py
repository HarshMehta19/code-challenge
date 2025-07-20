class Solution:
    # Modified binary search: if subarray is sorted, update result and break; otherwise, compare mid with start to decide which half to search while tracking the minimum.

    def findMin(self, nums: List[int]) -> int:
        res = nums[0]
        start, end = 0, len(nums) - 1

        while start <= end:
            if nums[start] < nums[end]:
                res = min(res, nums[start])
                break
            mid = start + (end - start) // 2
            res = min(res, nums[mid])
            if nums[mid] >= nums[start]:
                start = mid + 1
            else:
                end = mid - 1

        return res