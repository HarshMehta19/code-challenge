class Solution:
    def kSum(self, nums: List[int], k: int) -> int:
        """
        Alternative implementation with clearer state representation
        """
        n = len(nums)
        max_sum = sum(max(0, x) for x in nums)
        
        if k == 1:
            return max_sum
        
        # Convert to absolute values and sort
        abs_nums = sorted([abs(x) for x in nums])
        
        # Max heap: (negative_sum, index, included_previous)
        heap = [(-max_sum, 0)]
        
        for _ in range(k - 1):
            neg_sum, idx = heapq.heappop(heap)
            current_sum = -neg_sum
            
            if idx < n:
                # Include current element (subtract its absolute value)
                heapq.heappush(heap, (-(current_sum - abs_nums[idx]), idx + 1))
                
                # Skip current element (only if we can avoid duplicates)
                if idx > 0:
                    heapq.heappush(heap, (-(current_sum + abs_nums[idx-1] - abs_nums[idx]), idx + 1))
        
        return -heap[0][0]