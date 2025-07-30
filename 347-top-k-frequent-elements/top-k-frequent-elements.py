class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = Counter(nums)
        heap = []

        for i in freq.keys():
            heappush(heap, (-freq[i], i))
        ans = []

        while k > 0:
            k-=1
            ans.append(heappop(heap)[1])

        return ans