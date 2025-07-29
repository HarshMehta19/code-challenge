class Solution:
    def numberOfWays(self, s: str) -> int:
        n = len(s)
        
        # Count total 0s and 1s
        total_zeros = s.count('0')
        total_ones = n - total_zeros
        
        result = 0
        zeros_seen = 0
        ones_seen = 0
        
        for i in range(n):
            if s[i] == '0':
                # Current is '0', so we need '1' on both sides for valid triplet
                # ones_seen = 1s to the left
                # (total_ones - ones_seen) = 1s to the right
                result += ones_seen * (total_ones - ones_seen)
                zeros_seen += 1
            else:
                # Current is '1', so we need '0' on both sides for valid triplet
                # zeros_seen = 0s to the left  
                # (total_zeros - zeros_seen) = 0s to the right
                result += zeros_seen * (total_zeros - zeros_seen)
                ones_seen += 1
        
        return result