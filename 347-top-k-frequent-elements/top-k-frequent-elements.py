class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = Counter(nums)
        heap = []

        for num, count in freq.items():
            heappush(heap, (count, num))

            if len(heap) > k:
                heapq.heappop(heap)
        ans = [pair[1] for pair in heap]

        return ans