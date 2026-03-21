class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        #---------------------------- Bottom Up ---------------------------#

        mem = [amount + 1] * (amount + 1)
        mem[0] = 0

        for a in range(1, amount + 1):
            for coin in coins:
                if a - coin >=0:
                    mem[a] = min(mem[a], 1 + mem[a - coin])

        return mem[amount] if mem[amount] != amount + 1 else -1


        #---------------------------- Top Down ---------------------------#
        # coins.sort()
        # memo = {}
        # def rec(target):
        #     if target == 0:
        #         return 0

        #     if target in memo:
        #         return memo[target]

        #     minRes = float("inf")

        #     for i in coins:
        #         if target - i >=0:
        #             minRes = min(minRes, 1 + rec(target - i))

        #     memo[target] = minRes
        #     return memo[target]

        # res = rec(amount)
        # return res if res != float("inf") else -1
            
            
