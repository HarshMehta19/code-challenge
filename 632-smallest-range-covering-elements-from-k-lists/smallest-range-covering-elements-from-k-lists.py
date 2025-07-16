class Solution:
    def smallestRange(self, nums: List[List[int]]) -> List[int]:
        k = len(nums)
        left = right = nums[0][0]
        min_heap = []
        for i in range(k):
            l = nums[i]
            left = min(left, l[0])
            right = max(right, l[0])
            heapq.heappush(min_heap, (l[0], i, 0)) # value, index of nested list, index of value inside a list (0, 1, 0), (5, 2, 0)
        res = [left, right]
        while True:
            val, index, pos = heapq.heappop(min_heap)
            pos+=1
            if pos == len(nums[index]):  return res
            new_val = nums[index][pos]
            heapq.heappush(min_heap, (new_val, index, pos))
            left = min_heap[0][0]
            right = max(right, new_val)

            if right - left < res[1] - res[0]:
                res = [left, right]
