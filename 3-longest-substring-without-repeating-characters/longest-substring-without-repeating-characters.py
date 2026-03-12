class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # character set to check character is included
        visitedCharacters = set()
        res,l = 0, 0
        for right in range(len(s)):
            while visitedCharacters and s[right] in visitedCharacters:
                visitedCharacters.remove(s[l])
                l+=1
            
            visitedCharacters.add(s[right])
            res = max(res, right - l + 1)

        return res
            
        