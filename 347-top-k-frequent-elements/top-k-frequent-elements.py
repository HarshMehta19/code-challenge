class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = [[] for _ in range(len(nums) + 1)]
        count = {}

        for num in nums:
            count[num] = count.get(num, 0) + 1

        for num, cnt in count.items():
            freq[cnt].append(num)

        res = []
        for idx in range(len(freq) - 1, -1, -1):
            for num in freq[idx]:
                res.append(num)

                if len(res) == k:
                    return res
        # freq = Counter(nums)
        # heap = []
        
        # for num, count in freq.items():
        #     heappush(heap, (count, num))

        #     if len(heap) > k:
        #         heapq.heappop(heap)
        # # ans = []
        # # for i in range(k):
        # #     ans.append(heap)
        # ans = [item[1] for item in heap]
        # return ans