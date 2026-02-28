class Solution:
    def concatenatedBinary(self, n: int) -> int:
        ans = 0
        length = 0
        Mod = 10 ** 9 + 7

        for num in range(1, n+1):
            if (num & (num-1) == 0):
                length+=1
            
            ans = (((ans << length) % Mod) + num) % Mod

        return ans