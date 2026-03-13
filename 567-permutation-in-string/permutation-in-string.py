class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        n1 = len(s1)
        n2 = len(s2)

        if n1 > n2: return False

        s1_freq, s2_freq = {}, {}

        for i in range(n1):
            s1_freq[s1[i]] = 1+s1_freq.get(s1[i], 0)
            s2_freq[s2[i]] = 1+s2_freq.get(s2[i], 0)

        if s1_freq == s2_freq:
            return True

        for i in range(n1, n2):
            s2_freq[s2[i]] = 1 + s2_freq.get(s2[i], 0)
            s2_freq[s2[i - n1]] -=1
            if not s2_freq[s2[i-n1]]:
                del s2_freq[s2[i-n1]]
            
            if s1_freq == s2_freq:
                return True

        return False