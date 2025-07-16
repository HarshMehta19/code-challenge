class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        res = 0
        last_buy = prices[0]
        for p in prices[1:]:
            if last_buy > p:
                last_buy = p
            
            res = max(res, p - last_buy)
        
        return res