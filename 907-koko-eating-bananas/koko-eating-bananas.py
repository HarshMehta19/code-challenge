class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        right = max(piles)
        
        left = 1
        res = right

        while left <= right:
            mid = (left + right) // 2
            totalHours = 0
            for i in piles:
                totalHours += math.ceil(i/mid)

            if totalHours <= h:
                res = min(res, mid)
                right = mid - 1
            else:
                left = mid + 1

        return res

