class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = Counter(nums)

        heap = []

        for key, val in freq.items():
            if len(heap) == k:
                if val > heap[0][0]:
                    heapq.heappop(heap)
                    heapq.heappush(heap, (val, key))
            else:
                heapq.heappush(heap, (val, key))

        ans = []
        for a, b in heap:
            ans.append(b)
        return ans