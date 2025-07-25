class Solution:
    def longestPalindrome(self, s: str) -> str:
        resIdx = 0
        resLen = 0

        for i in range(len(s)):

            l,r = i, i

            while l >= 0 and r < len(s) and s[l] == s[r]:
                if (r - l + 1) > resLen:
                    resLen = r - l + 1
                    resIdx = l
                l-=1
                r+=1

            # odd length

            l,r = i, i+1

            while l >= 0 and r < len(s) and s[l] == s[r]:
                if (r-l+1) > resLen:
                    resLen = r - l + 1
                    resIdx = l
                l-=1
                r+=1
            
        return s[resIdx: resIdx+resLen]