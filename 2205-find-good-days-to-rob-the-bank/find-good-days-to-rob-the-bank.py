class Solution:
    def goodDaysToRobBank(self, security: List[int], time: int) -> List[int]:
        n = len(security)
        
        # Edge case
        if time == 0: return list(range(n))

        dec, inc = [0]*n, [0]*n
        # Store num of values decreasing from the left
        for i in range(1, n):
            if security[i] <= security[i-1]:
                dec[i] = dec[i-1] + 1
        # Store num of values increasing from the right
        for i in range(n-2, -1, -1):
            if security[i] <= security[i+1]:
                inc[i] = inc[i+1] + 1
        
        # Return valid index
        return [i for i in range(time, n-time) if dec[i] >= time and inc[i] >= time]