from functools import lru_cache
from typing import List
class Solution:

    def coinChange(self, coins: List[int], amount: int) -> int:
        """
        Returns the minimum number of coins needed to make up `amount`.
        If it's not possible, returns -1.

        Top-down DFS with memoization:
        - Time  : O(N * A) where N = len(coins), A = amount
        - Space : O(A) for the memo + recursion depth up to A / min(coins)
        """
        if amount < 0:
            return -1
        if amount == 0:
            return 0

        # Deduplicate and ignore non-positive coins to avoid useless work.
        usable = [c for c in set(coins) if c > 0]
        if not usable:
            return -1

        INF = float("inf")

        @lru_cache(None)
        def dfs(rem: int) -> int:
            if rem == 0:
                return 0
            best = INF
            for c in usable:
                if c <= rem:
                    sub = dfs(rem - c)
                    if sub != INF:
                        best = min(best, sub + 1)
            return best

        ans = dfs(amount)
        return -1 if ans == INF else ans

