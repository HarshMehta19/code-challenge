class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = Counter(nums)
        heap = []

        for i in freq.keys():
            heappush(heap, (freq[i], i))

            if len(heap) > k:
                heapq.heappop(heap)
        ans = [pair[1] for pair in heap]

        return ans