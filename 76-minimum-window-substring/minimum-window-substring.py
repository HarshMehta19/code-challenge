class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if s == t: return t

        countT, window = {}, {}

        for c in t:
            countT[c]=1 + countT.get(c, 0)
        
        have, need = 0, len(countT)
        res, resLen = [-1, -1], float("inf")
        l = 0
        for r in range(len(s)):
            c = s[r]
            window[c] = 1+window.get(c,0)

            if c in countT and countT[c] == window[c]:
                have+=1

            while have == need:
                if (r-l+1) < resLen:
                    res = [l, r]
                    resLen = r - l + 1
                
                window[s[l]] -=1
                if s[l] in countT and window[s[l]] < countT[s[l]]:
                    have-=1

                l +=1

        l, r = res[0], res[1]
        return s[l:r+1] if resLen != float("inf") else ""




