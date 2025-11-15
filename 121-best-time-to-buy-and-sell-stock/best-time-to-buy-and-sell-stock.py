class Solution:
    def maxProfit(self, prices: List[int]) -> int:

        res = 0

        last_buy = prices[0]
        for price in prices[1:]:
            if last_buy > price:
                last_buy = price

            res = max(res, price - last_buy)

        return res